package lunarmonhorizons.block.blocks.pedestals;

import lunarmonhorizons.block.entities.pedestals.AbstractPedestalBlockEntity;
import lunarmonhorizons.block.entities.pedestals.basic.BasicPedestalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPedestalBlock extends BaseEntityBlock {

    private static final VoxelShape SHAPE =
            Block.box(2, 0, 2, 14, 13, 14);

    public AbstractPedestalBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BasicPedestalBlockEntity(pos, state);
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
                                           CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
                                                        BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity be = level.getBlockEntity(pos);

        if (!(be instanceof AbstractPedestalBlockEntity pedestal)) {
            return InteractionResult.PASS;
        }

        ItemStack held = player.getItemInHand(InteractionHand.MAIN_HAND);

        if (!held.isEmpty()) {
            ItemStack copyHeld = held.copy();
            ItemStack toSet = pedestal.tryInsert(held, (ServerPlayer) player);
            if (!ItemStack.isSameItemSameComponents(toSet, copyHeld)) { // If the resulted item got changed
                playSound(level, pos);
                player.setItemInHand(InteractionHand.MAIN_HAND, toSet);
            }
            return InteractionResult.CONSUME;
        }

        if (!pedestal.isEmpty() && held.isEmpty() && !player.isShiftKeyDown()) {

            ItemStack extracted = pedestal.extract((ServerPlayer) player);

            if (!extracted.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, extracted);
                playSound(level, pos);
                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.SUCCESS; // Cancels even block placements or any type of item executions
    }

    // TODO: Drop items if empty
    @Override
    protected void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        super.onRemove(blockState, level, blockPos, blockState2, bl);
    }

    private void playSound(Level level, BlockPos pos) {
        level.playSound(
                null,
                pos,
                SoundEvents.ITEM_PICKUP,
                SoundSource.BLOCKS,
                1.0F,
                1.0F
        );

        level.sendBlockUpdated(pos, level.getBlockState(pos), level.getBlockState(pos), Block.UPDATE_ALL);
    }

    protected Component getTooltip() {
        return Component.translatable("tooltip.lunarmon-horizons.pedestal_base");
    }
}