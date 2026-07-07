package lunarmonhorizons.block.entities.pedestals;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractPedestalBlockEntity extends BlockEntity {

    private final SimpleContainer inventory = new SimpleContainer(1);

    private boolean activated = false;

    public AbstractPedestalBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public PedestalInsertResult tryInsert(ItemStack stack, ServerPlayer player) {

        if (!isItemValid(stack, player)) {
            return new PedestalInsertResult(stack, ItemStack.EMPTY, false);
        }

        ItemStack old = inventory.getItem(0).copy();

        if (ItemStack.isSameItemSameComponents(old, stack)) {
            return new PedestalInsertResult(stack, ItemStack.EMPTY, false);
        }

        ItemStack pedestalStack = stack.copyWithCount(1);

        boolean swap = !old.isEmpty() && canSwap(old, stack, player);

        if (old.isEmpty() || swap) {
            ItemStack remainingHand = stack.copy();
            remainingHand.shrink(1);
            inventory.setItem(0, pedestalStack);
            setChanged();
            sync();
            onItemChanged(old, pedestalStack, swap ? State.SWAPPED : State.INSERTED);
            return new PedestalInsertResult(remainingHand, swap ? old : ItemStack.EMPTY, true);
        }

        return new PedestalInsertResult(stack, ItemStack.EMPTY, false);
    }

    public ItemStack extract(ServerPlayer player) {
        ItemStack old = inventory.getItem(0).copy();

        if (isEmpty() || !canTakeItem(old, player)) return ItemStack.EMPTY;

        inventory.setItem(0, ItemStack.EMPTY);

        setChanged();
        sync();

        onItemChanged(old, ItemStack.EMPTY, State.EXTRACTED);

        return old;
    }

    public boolean isEmpty() {
        return inventory.getItem(0).isEmpty();
    }

    public ItemStack getItem() {
        return inventory.getItem(0);
    }

    private void sync() {
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    protected void onItemChanged(ItemStack oldStack, ItemStack newStack, State state) { }

    protected boolean isItemValid(ItemStack stack, ServerPlayer player){ return true; }
    protected boolean canTakeItem(ItemStack stack, ServerPlayer player){ return true; }
    protected boolean canSwap(ItemStack pedestalStack, ItemStack playerStack, ServerPlayer player){ return true; }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        if (!inventory.getItem(0).isEmpty()) {
            tag.put("Item", inventory.getItem(0).save(registries));
        }

        tag.putBoolean("Activated", activated);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        inventory.clearContent();

        if (tag.contains("Item")) {
            inventory.setItem(0,
                    ItemStack.parse(registries, tag.getCompound("Item"))
                            .orElse(ItemStack.EMPTY)
            );
        }

        activated = tag.getBoolean("Activated");
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    public enum State {
        INSERTED,
        EXTRACTED,
        SWAPPED
    }

    public record PedestalInsertResult(
            ItemStack remainingHand,
            ItemStack returnedItem,
            boolean changed
    ) {
    }
}