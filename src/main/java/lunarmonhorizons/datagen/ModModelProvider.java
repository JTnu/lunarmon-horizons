package lunarmonhorizons.datagen;

import lunarmonhorizons.block.ModBlocks;
import lunarmonhorizons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.PEDESTAL_BASE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RAYQUAZA_PEDESTAL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.SPAWNING_ANCHOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.SKY_FRAGMENT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ICE_FEATHER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHARGED_FEATHER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FLAME_FEATHER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAINBOW_FEATHER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PURE_HEART, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GENETIC_CORE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PURE_WATER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SILVER_CONCH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.STONE_TABLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FROZEN_TABLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.METAL_TABLET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RED_SOUL_ORB, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BLUE_SOUL_ORB, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OCEAN_HEART, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MAGMA_HEART, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MAGMA_KEYSTONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.STEEL_SIGIL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SACRED_LEAF, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TRUTH_CRYSTAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.IDEALS_CRYSTAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WORLD_SAPLING, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OBSIDIAN_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PRISON_BOTTLE_FRAGMENT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PRISON_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GUARDIANS_CREST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HEROS_CREST, ModelTemplates.FLAT_ITEM);
    }
}
