package lunarmonhorizons.block.entities.pedestals.basic;

import lunarmonhorizons.block.entities.ModBlockEntities;
import lunarmonhorizons.block.entities.pedestals.AbstractPedestalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BasicPedestalBlockEntity extends AbstractPedestalBlockEntity {
    public BasicPedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PEDESTAL_BE, pos, state);
    }
}
