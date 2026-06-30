package lunarmonhorizons.item;

import lunarmonhorizons.LunarMonHorizons;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ModItems {

    public static final Item SKY_FRAGMENT = registerItem("sky_fragment",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                             TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.sky_fragment.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item ICE_FEATHER = registerItem("ice_feather",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.ice_feather.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }

    );
    public static final Item CHARGED_FEATHER = registerItem("charged_feather",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.charged_feather.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );
    public static final Item FLAME_FEATHER = registerItem("flame_feather",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.flame_feather.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }

    );
    public static final Item RAINBOW_FEATHER = registerItem("rainbow_feather",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.rainbow_feather.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );
    public static final Item PURE_HEART = registerItem("pure_heart",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.pure_heart.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }

    );
    public static final Item GENETIC_CORE = registerItem("genetic_core",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.genetic_core.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item PURE_WATER = registerItem("pure_water",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.pure_water.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item SILVER_CONCH = registerItem("silver_conch",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.silver_conch.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item STONE_TABLET = registerItem("stone_tablet",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.stone_tablet.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item FROZEN_TABLET = registerItem("frozen_tablet",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.frozen_tablet.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item METAL_TABLET = registerItem("metal_tablet",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.metal_tablet.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item RED_SOUL_ORB = registerItem("red_soul_orb",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.red_soul_orb.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item BLUE_SOUL_ORB = registerItem("blue_soul_orb",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.blue_soul_orb.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item OCEAN_HEART = registerItem("ocean_heart",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.ocean_heart.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item MAGMA_HEART = registerItem("magma_heart",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.magma_heart.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item MAGMA_KEYSTONE = registerItem("magma_keystone",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.magma_keystone.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item DREAM_CATCHER = registerItem("dream_catcher",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.dream_catcher.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item STEEL_SIGIL = registerItem("steel_sigil",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.steel_sigil.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item SACRED_LEAF = registerItem("sacred_leaf",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.sacred_leaf.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item TRUTH_CRYSTAL = registerItem("truth_crystal",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.truth_crystal.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item IDEALS_CRYSTAL = registerItem("ideals_crystal",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.ideals_crystal.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item WORLD_SAPLING = registerItem("world_sapling",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.world_sapling.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.obsidian_shard.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item PRISON_BOTTLE_FRAGMENT = registerItem("prison_bottle_fragment",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.prison_bottle_fragment.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item PRISON_BOTTLE = registerItem("prison_bottle",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.prison_bottle.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item GUARDIANS_CREST = registerItem("guardians_crest",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.guardians_crest.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );

    public static final Item HEROS_CREST = registerItem("heros_crest",
            new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack,
                                            Item.TooltipContext context,
                                            List<Component> tooltip,
                                            TooltipFlag flag) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.heros_crest.shift"
                        ));
                    } else {
                        tooltip.add(Component.translatable(
                                "tooltip.lunarmonhorizons.hold_shift"
                        ));
                    }
                }
            }
    );


    private static Item registerItem(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(LunarMonHorizons.MOD_ID, name),
                item
        );
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(SKY_FRAGMENT);
            entries.accept(ICE_FEATHER);
        });
    }
}