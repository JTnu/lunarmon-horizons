package lunarmonhorizons.block.custom;

import com.mojang.serialization.MapCodec;
import lunarmonhorizons.block.entity.custom.PedestalBlockEntity;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PedestalBlock extends BaseEntityBlock {

    public static final MapCodec<PedestalBlock> CODEC = simpleCodec(PedestalBlock::new);

    private static final VoxelShape SHAPE =
            Block.box(2, 0, 2, 14, 13, 14);

    public PedestalBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state,
                                           BlockGetter level,
                                           BlockPos pos,
                                           CollisionContext context) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PedestalBlockEntity(pos, state);
    }

    @Override
    protected @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState,
                            boolean movedByPiston) {

        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);

            if (be instanceof PedestalBlockEntity pedestal) {
                Block.popResource(level, pos, pedestal.getItem(0));
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, movedByPiston);
        }
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
                                                        BlockHitResult hit) {

        if (!(level.getBlockEntity(pos) instanceof PedestalBlockEntity pedestal)) {
            return InteractionResult.PASS;
        }

        ItemStack held = player.getItemInHand(InteractionHand.MAIN_HAND);

        if (pedestal.isEmpty() && !held.isEmpty()) {

            pedestal.setItem(0, held.copyWithCount(1));
            held.shrink(1);

            level.playSound(
                    null,
                    pos,
                    SoundEvents.ITEM_PICKUP,
                    SoundSource.BLOCKS,
                    1.0F,
                    2.0F
            );

            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        }

        if (held.isEmpty() && !player.isShiftKeyDown()) {

            ItemStack extracted = pedestal.getItem(0);

            player.setItemInHand(InteractionHand.MAIN_HAND, extracted);
            pedestal.clearContent();

            level.playSound(
                    null,
                    pos,
                    SoundEvents.ITEM_PICKUP,
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F
            );

            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {

        if (Screen.hasShiftDown()) {
            tooltip.add(getTooltip());
        } else {
            tooltip.add(Component.translatable("tooltip.lunarmonhorizons.hold_shift"));
        }
    }

    protected Component getTooltip() {
        return Component.translatable("tooltip.lunarmon-horizons.pedestal_base");
    }
}