package lunarmonhorizons.block.blocks.pedestals.summoning;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import lunarmonhorizons.block.blocks.pedestals.PredicatedPedestalBlock;
import lunarmonhorizons.block.entities.ModBlockEntities;
import lunarmonhorizons.block.entities.pedestals.summoning.SimpleSummoningPedestalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class SimpleSummoningPedestalBlock extends PredicatedPedestalBlock implements EntityBlock {

    public static final MapCodec<SimpleSummoningPedestalBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            propertiesCodec(),
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(block -> block.requiredItem)
    ).apply(instance, SimpleSummoningPedestalBlock::new));

    protected Consumer<SimpleSummoningPedestalBlockEntity> summoning;

    public SimpleSummoningPedestalBlock(Properties properties, Item requiredItem) { // Client stuff
        super(properties, requiredItem);
    }

    public SimpleSummoningPedestalBlock(Properties properties, Item requiredItem, Consumer<SimpleSummoningPedestalBlockEntity> summoning) {
        super(properties, requiredItem);
        this.summoning = summoning;
    }

    @Override
    protected Component getTooltip() {
        return Component.translatable("tooltip.lunarmonhorizons.block." + BuiltInRegistries.BLOCK.getKey(this).getPath());
    }

    public void summon(SimpleSummoningPedestalBlockEntity entity) {
        if (this.summoning != null) this.summoning.accept(entity);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SimpleSummoningPedestalBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.SPAWNING_PEDESTAL_BE, SimpleSummoningPedestalBlockEntity::serverTick);
    }
}
