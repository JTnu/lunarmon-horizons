package lunarmonhorizons.block.custom;

import com.mojang.serialization.MapCodec;
import lunarmonhorizons.block.entity.PedestalType;
import lunarmonhorizons.block.entity.custom.PedestalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class RayquazaPedestalBlock extends PedestalBlock {

    public static final MapCodec<RayquazaPedestalBlock> CODEC =
            simpleCodec(RayquazaPedestalBlock::new);

    public RayquazaPedestalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        PedestalBlockEntity be = new PedestalBlockEntity(pos, state);
        be.setPedestalType(PedestalType.RAYQUAZA);
        return be;
    }

    @Override
    protected @NotNull MapCodec<? extends PedestalBlock> codec() {
        return CODEC;
    }

    @Override
    protected Component getTooltip() {
        return Component.translatable(
                "tooltip.lunarmon-horizons.rayquaza_pedestal"
        );
    }
}