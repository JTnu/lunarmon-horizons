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

public abstract class AbstractPedestalBlockEntity extends BlockEntity { // Check BaseContainerBlockEntity

    private final SimpleContainer inventory = new SimpleContainer(1);

    private boolean activated = false;

    public AbstractPedestalBlockEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // Executes when the hand stack is not empty
    // TODO: Swapping mechanic
    public ItemStack tryInsert(ItemStack stack, ServerPlayer player) {

        if (!isItemValid(stack, player)) return stack;

        ItemStack old = inventory.getItem(0).copy();
        if (ItemStack.isSameItemSameComponents(old, stack)) return stack;

        ItemStack newStack =  stack.copyWithCount(1);

        boolean canSwap = !old.isEmpty() && stack.getCount() == 1 && canSwap(old, stack, player);

        if (old.isEmpty() || canSwap) { // If empty will set as usual, swaps if the item is exactly 1 count
            stack.shrink(1);
            inventory.setItem(0, newStack);
            setChanged();
            sync();
            onItemChanged(old.copy(), stack, canSwap ? State.SWAPPED : State.INSERTED);
            if (canSwap) return old; // Returns the item from the pedestal
        }

        return stack; // Returns the item as the same or removed a count
    }

    // Executes when the hand stack is empty
    public ItemStack extract(ServerPlayer player) {
        ItemStack old = inventory.getItem(0).copy();

        if (isEmpty() || !canTakeItem(old, player)) return ItemStack.EMPTY;

        ItemStack result = inventory.getItem(0);
        inventory.setItem(0, ItemStack.EMPTY);

        setChanged();
        sync();

        onItemChanged(old, ItemStack.EMPTY, State.EXTRACTED);

        return result;
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
        SWAPPED;
    }

}