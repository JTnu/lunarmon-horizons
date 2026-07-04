package lunarmonhorizons.item;

import lunarmonhorizons.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final ResourceKey<CreativeModeTab> HORIZONS_ITEMS_KEY =
            ResourceKey.create(
                    Registries.CREATIVE_MODE_TAB,
                    ResourceLocation.fromNamespaceAndPath("lunarmon-horizons", "horizons_items")
            );

    public static final CreativeModeTab HORIZONS_ITEMS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.PURE_HEART))
            .title(Component.translatable("itemGroup.lunarmon-horizons.horizons_items"))
            .displayItems((params, output) -> {

                output.accept(ModItems.SKY_FRAGMENT);
                output.accept(ModItems.ICE_FEATHER);
                output.accept(ModItems.CHARGED_FEATHER);
                output.accept(ModItems.FLAME_FEATHER);
                output.accept(ModItems.RAINBOW_FEATHER);
                output.accept(ModItems.PURE_HEART);
                output.accept(ModItems.GENETIC_CORE);
                output.accept(ModItems.DREAM_CATCHER);
                output.accept(ModItems.PURE_WATER);
                output.accept(ModItems.OCEAN_HEART);
                output.accept(ModItems.MAGMA_HEART);
                output.accept(ModItems.MAGMA_KEYSTONE);
                output.accept(ModItems.IDEALS_CRYSTAL);
                output.accept(ModItems.TRUTH_CRYSTAL);
                output.accept(ModItems.FROZEN_TABLET);
                output.accept(ModItems.STONE_TABLET);
                output.accept(ModItems.METAL_TABLET);
                output.accept(ModItems.SILVER_CONCH);
                output.accept(ModItems.STEEL_SIGIL);
                output.accept(ModItems.SACRED_LEAF);
                output.accept(ModItems.RED_SOUL_ORB);
                output.accept(ModItems.BLUE_SOUL_ORB);
                output.accept(ModItems.HEROS_CREST);
                output.accept(ModItems.GUARDIANS_CREST);
                output.accept(ModItems.WORLD_SAPLING);
                output.accept(ModItems.OBSIDIAN_SHARD);
                output.accept(ModItems.PRISON_BOTTLE_FRAGMENT);
                output.accept(ModItems.PRISON_BOTTLE);
            })
            .build();

    public static final ResourceKey<CreativeModeTab> HORIZONS_BLOCKS_KEY =
            ResourceKey.create(
                    Registries.CREATIVE_MODE_TAB,
                    ResourceLocation.fromNamespaceAndPath("lunarmon-horizons", "horizons_blocks")
            );

    public static final CreativeModeTab HORIZONS_BLOCKS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.PEDESTAL_BASE))
            .title(Component.translatable("itemGroup.lunarmon-horizons.horizons_blocks"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.PEDESTAL_BASE);
                output.accept(ModBlocks.RAYQUAZA_PEDESTAL);
                output.accept(ModBlocks.SPAWNING_ANCHOR);
            })
            .build();

    public static void registerItemGroups() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, HORIZONS_ITEMS_KEY, HORIZONS_ITEMS_GROUP);

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, HORIZONS_BLOCKS_KEY, HORIZONS_BLOCKS_GROUP);
    }
}