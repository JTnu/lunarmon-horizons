package lunarmonhorizons.block.entities.pedestals.summoning;

import lunarmonhorizons.LunarMonHorizons;
import lunarmonhorizons.block.blocks.pedestals.summoning.SimpleSummoningPedestalBlock;
import lunarmonhorizons.block.entities.ModBlockEntities;
import lunarmonhorizons.block.entities.anchor.SpawningAnchorBlockEntity;
import lunarmonhorizons.block.entities.pedestals.PredicatedPedestalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

/**
 * A simple summoning pedestal<br/>
 * Immediately summons an entity after right-clicking with the required item
 */
public class SimpleSummoningPedestalBlockEntity extends PredicatedPedestalBlockEntity {

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, SimpleSummoningPedestalBlockEntity entity) {
        entity.tick();
    }

    protected BlockPos anchorPos = new BlockPos(0, 0, 0);
    protected boolean spawnAtAnchor = false; // Mostly used when the anchor has been found
    protected int ticksSinceLast = 0;

    public SimpleSummoningPedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPAWNING_PEDESTAL_BE, pos, state);
    }

    /**
     * Gets the spawning position for the pedestal
     */
    public BlockPos getSpawningPos(){
        return spawnAtAnchor ? anchorPos : this.getBlockPos().above();
    }

    private void updateSpawningAnchor(){
        if (!(this.level instanceof ServerLevel) && !spawnAtAnchor) return;
        int startingChunkX = (this.getBlockPos().getX() >> 4) - 1;
        int startingChunkY = (this.getBlockPos().getZ() >> 4) - 1;
        // Checks the 3x3 chunks in its vicinity
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int chunkX = startingChunkX + i;
                int chunkY = startingChunkY + j;
                if (!this.level.hasChunk(chunkX, chunkY)) continue;
                for (Map.Entry<BlockPos, BlockEntity> block : this.level.getChunk(chunkX, chunkY).getBlockEntities().entrySet()) {
                    if (!(block.getValue() instanceof SpawningAnchorBlockEntity anchor)) continue;
                    anchorPos = block.getKey();
                    spawnAtAnchor = true;
                    this.onAnchorFound(anchor);
                }
            }
        }
    }

    public boolean canSpawnAtAnchor(){
        return this.spawnAtAnchor;
    }

    /**
     * Runs when the anchor block entity is found in a 3x3 chunk with the summoning pedestal in the center <br/>
     * and again, can add cool animations or timer if needed
     */
    protected void onAnchorFound(SpawningAnchorBlockEntity anchorEntity){
        if (this.level == null) return;
        this.level.removeBlock(anchorEntity.getBlockPos(), false);
        this.level.removeBlockEntity(anchorEntity.getBlockPos());
    }

    public void tick(){
        ticksSinceLast++;
        onTick();
    }

    protected void onTick() {
        if (ticksSinceLast % 40 == 0 && (this.anchorPos == null || !this.spawnAtAnchor)) { // Checks every 2 seconds and the anchor is not yet found
            updateSpawningAnchor();
        }
    }

    // TODO: Add timed based reactivation mechanic
    /**
     * Only get called when it is successful
     */
    @Override
    protected void onItemChanged(ItemStack oldStack, ItemStack newStack, State state) {
        if (!(level instanceof ServerLevel)) return;
        switch (state){
            case INSERTED, SWAPPED -> {
                ((SimpleSummoningPedestalBlock) this.getBlockState().getBlock()).summon(this);
            }
            case EXTRACTED -> { } // Do nothing
        }
    }

    @Override
    protected boolean canTakeItem(ItemStack stack, ServerPlayer player) {
        return this.isEmpty(); // Example use case, can't take out the item again
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("anchor")) this.anchorPos = BlockPos.of(tag.getLong("anchor"));
        if (tag.contains("spawn_at_anchor")) this.spawnAtAnchor = tag.getBoolean("spawn_at_anchor");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putLong("anchor", this.anchorPos.asLong());
        tag.putBoolean("spawn_at_anchor", this.spawnAtAnchor);
    }
}
