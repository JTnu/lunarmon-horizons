package lunarmonhorizons.block.blocks.anchor;

import com.mojang.serialization.MapCodec;
import lunarmonhorizons.block.entities.anchor.SpawningAnchorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SpawningAnchorBlock extends BaseEntityBlock {

    public static final MapCodec<SpawningAnchorBlock> CODEC = simpleCodec(SpawningAnchorBlock::new);

    public SpawningAnchorBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<SpawningAnchorBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SpawningAnchorBlockEntity(blockPos, blockState);
    }
}
