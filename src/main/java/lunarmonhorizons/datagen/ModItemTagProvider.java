package lunarmonhorizons.datagen;

import lunarmonhorizons.item.ModItems;
import lunarmonhorizons.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.SUMMONING_ITEMS)
                .add(ModItems.SKY_FRAGMENT)
                .add(ModItems.ICE_FEATHER)
                .add(ModItems.CHARGED_FEATHER)
                .add(ModItems.FLAME_FEATHER)
                .add(ModItems.RAINBOW_FEATHER)
                .add(ModItems.PURE_HEART)
                .add(ModItems.GENETIC_CORE)
                .add(ModItems.PURE_WATER)
                .add(ModItems.SILVER_CONCH)
                .add(ModItems.STONE_TABLET)
                .add(ModItems.FROZEN_TABLET)
                .add(ModItems.METAL_TABLET)
                .add(ModItems.RED_SOUL_ORB)
                .add(ModItems.BLUE_SOUL_ORB)
                .add(ModItems.OCEAN_HEART)
                .add(ModItems.MAGMA_HEART)
                .add(ModItems.MAGMA_KEYSTONE)
                .add(ModItems.DREAM_CATCHER)
                .add(ModItems.STEEL_SIGIL)
                .add(ModItems.SACRED_LEAF)
                .add(ModItems.TRUTH_CRYSTAL)
                .add(ModItems.IDEALS_CRYSTAL)
                .add(ModItems.WORLD_SAPLING)
                .add(ModItems.OBSIDIAN_SHARD)
                .add(ModItems.PRISON_BOTTLE)
                .add(ModItems.GUARDIANS_CREST)
                .add(ModItems.HEROS_CREST);
    }
}
