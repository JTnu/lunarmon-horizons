package lunarmonhorizons.block.entities.anchor;

import lunarmonhorizons.block.entities.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SpawningAnchorBlockEntity extends BlockEntity {

    public SpawningAnchorBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.SPAWNING_ANCHOR_BE, blockPos, blockState);
    }

}
