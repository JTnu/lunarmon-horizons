package lunarmonhorizons.block.entities.pedestals;

import lunarmonhorizons.LunarMonHorizons;
import lunarmonhorizons.block.blocks.pedestals.PredicatedPedestalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Basis of all summoning pedestals<br/>
 * Requires a specific item to initiate
 */
public abstract class PredicatedPedestalBlockEntity extends AbstractPedestalBlockEntity {

    public PredicatedPedestalBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected boolean isItemValid(ItemStack stack, ServerPlayer player) {
        Item requiredItem = this.getRequiredItem();
        LunarMonHorizons.LOGGER.info("{}", requiredItem == Items.AIR || stack.is(requiredItem));
        return requiredItem == Items.AIR || stack.is(requiredItem);
    }

    public Item getRequiredItem(){
        return this.getBlockState().getBlock() instanceof PredicatedPedestalBlock block ? block.getRequiredItem() : Items.AIR;
    }

}
