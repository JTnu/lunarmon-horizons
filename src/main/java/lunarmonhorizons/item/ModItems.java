package lunarmonhorizons.item;

import lunarmonhorizons.LunarMonHorizons;
import lunarmonhorizons.item.custom.SummoningItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item SKY_FRAGMENT = registerSummoningItem("sky_fragment");
    public static final Item ICE_FEATHER = registerSummoningItem("ice_feather");
    public static final Item CHARGED_FEATHER = registerSummoningItem("charged_feather");
    public static final Item FLAME_FEATHER = registerSummoningItem("flame_feather");
    public static final Item RAINBOW_FEATHER = registerSummoningItem("rainbow_feather");
    public static final Item PURE_HEART = registerSummoningItem("pure_heart");
    public static final Item GENETIC_CORE = registerSummoningItem("genetic_core");
    public static final Item PURE_WATER = registerSummoningItem("pure_water");
    public static final Item SILVER_CONCH = registerSummoningItem("silver_conch");
    public static final Item STONE_TABLET = registerSummoningItem("stone_tablet");
    public static final Item FROZEN_TABLET = registerSummoningItem("frozen_tablet");
    public static final Item METAL_TABLET = registerSummoningItem("metal_tablet");
    public static final Item RED_SOUL_ORB = registerSummoningItem("red_soul_orb");
    public static final Item BLUE_SOUL_ORB = registerSummoningItem("blue_soul_orb");
    public static final Item OCEAN_HEART = registerSummoningItem("ocean_heart");
    public static final Item MAGMA_HEART = registerSummoningItem("magma_heart");
    public static final Item MAGMA_KEYSTONE = registerSummoningItem("magma_keystone");
    public static final Item DREAM_CATCHER = registerSummoningItem("dream_catcher");
    public static final Item STEEL_SIGIL = registerSummoningItem("steel_sigil");
    public static final Item SACRED_LEAF = registerSummoningItem("sacred_leaf");
    public static final Item TRUTH_CRYSTAL = registerSummoningItem("truth_crystal");
    public static final Item IDEALS_CRYSTAL = registerSummoningItem("ideals_crystal");
    public static final Item WORLD_SAPLING = registerSummoningItem("world_sapling");
    public static final Item OBSIDIAN_SHARD = registerSummoningItem("obsidian_shard");
    public static final Item PRISON_BOTTLE_FRAGMENT = registerSummoningItem("prison_bottle_fragment");
    public static final Item PRISON_BOTTLE = registerSummoningItem("prison_bottle");
    public static final Item GUARDIANS_CREST = registerSummoningItem("guardians_crest");
    public static final Item HEROS_CREST = registerSummoningItem("heros_crest");
    public static final Item STEAM_CORE = registerSummoningItem("steam_core");

    private static SummoningItem registerSummoningItem(String name){
        return registerSummoningItem(name, Component.translatable("tooltip.lunarmonhorizons." + name + ".shift"));
    }

    /**
     * Optional if a different translation is used
     */
    private static SummoningItem registerSummoningItem(String name, Component translatable){
        return (SummoningItem) registerItem(name, new SummoningItem(new Item.Properties().stacksTo(1), translatable));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                LunarMonHorizons.of(name),
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