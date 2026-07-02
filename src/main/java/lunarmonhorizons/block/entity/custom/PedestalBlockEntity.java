package lunarmonhorizons.block.entity.custom;

import lunarmonhorizons.block.entity.ModBlockEntities;
import lunarmonhorizons.block.entity.PedestalType;
import lunarmonhorizons.block.entity.logic.RayquazaLogic;
import lunarmonhorizons.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PedestalBlockEntity extends BlockEntity {

    private final SimpleContainer inventory = new SimpleContainer(1);

    private PedestalType pedestalType = PedestalType.DEFAULT;
    private boolean activated = false;

    public PedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PEDESTAL_BE, pos, state);
    }

    public void setPedestalType(PedestalType type) {
        this.pedestalType = type;
    }
    public boolean tryInsert(ItemStack stack) {

        if (!isEmpty()) return false;

        System.out.println("[Pedestal] tryInsert called with: " + stack); // Temp Debug | Item Insertion //

        ItemStack old = inventory.getItem(0).copy();

        inventory.setItem(0, stack);

        setChanged();
        sync();

        onItemChanged(old, stack);

        return true;
    }

    public ItemStack extract() {

        if (isEmpty()) return ItemStack.EMPTY;

        ItemStack old = inventory.getItem(0).copy();
        ItemStack result = inventory.getItem(0);

        System.out.println("[Pedestal] extract called, returning: " + result); // Temp Debug | Item Extraction //

        inventory.setItem(0, ItemStack.EMPTY);

        setChanged();
        sync();

        onItemChanged(old, ItemStack.EMPTY);

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

    protected void onItemChanged(ItemStack oldStack, ItemStack newStack) {

        System.out.println("[Pedestal] onItemChanged: " + oldStack + " -> " + newStack); // Temp Debug | Item Change //
        System.out.println("[Pedestal] TYPE IS: " + pedestalType); // Temp Debug | Pedestal Type Check //

        if (level == null || level.isClientSide) {
            return;
        }

        if (activated) {
            System.out.println("[Pedestal] already activated"); // Temp Debug | Multi-Use Check //
            return;
        }

        if (pedestalType == PedestalType.RAYQUAZA) {

            if (!oldStack.is(ModItems.SKY_FRAGMENT)
                    && newStack.is(ModItems.SKY_FRAGMENT)) {

                System.out.println("[Pedestal] RAYQUAZA TRIGGER CONDITION MET"); // Temp Debug | Proper Item Insertion //

                activated = true;

                if (level instanceof ServerLevel serverLevel) {
                    System.out.println("[Pedestal] CALLING RayquazaLogic.trigger()"); // Temp Debug | Logic Call //
                    RayquazaLogic.trigger(serverLevel, worldPosition);
                    extract();
                } else {
                    System.out.println("[Pedestal] NOT SERVER LEVEL"); // Temp Debug | Fail //
                }
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        if (!inventory.getItem(0).isEmpty()) {
            tag.put("Item", inventory.getItem(0).save(registries));
        }

        tag.putString("PedestalType", pedestalType.name());
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

        if (tag.contains("PedestalType")) {
            pedestalType = PedestalType.valueOf(tag.getString("PedestalType"));
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
}