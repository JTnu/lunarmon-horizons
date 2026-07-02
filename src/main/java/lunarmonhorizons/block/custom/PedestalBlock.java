package lunarmonhorizons.block.custom;

import com.mojang.serialization.MapCodec;
import lunarmonhorizons.block.entity.PedestalType;
import lunarmonhorizons.block.entity.custom.PedestalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
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
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {

        PedestalBlockEntity be = new PedestalBlockEntity(pos, state);

        be.setPedestalType(PedestalType.DEFAULT);

        return be;
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

        if (!(be instanceof PedestalBlockEntity pedestal)) {
            return InteractionResult.PASS;
        }

        ItemStack held = player.getItemInHand(InteractionHand.MAIN_HAND);

        if (pedestal.isEmpty() && !held.isEmpty()) {

            if (pedestal.tryInsert(held.copyWithCount(1))) {
                held.shrink(1);
                playSound(level, pos);
                return InteractionResult.CONSUME;
            }
        }

        if (!pedestal.isEmpty() && held.isEmpty() && !player.isShiftKeyDown()) {

            ItemStack extracted = pedestal.extract();

            if (!extracted.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, extracted);
                playSound(level, pos);
                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.PASS;
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