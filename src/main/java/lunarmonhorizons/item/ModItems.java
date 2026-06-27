package lunarmonhorizons.item;

import lunarmonhorizons.LunarMonHorizons;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item SKY_FRAGMENT = registerItem("sky_fragment", new Item(new Item.Properties()));
    public static final Item ICE_FEATHER = registerItem("ice_feather", new Item(new Item.Properties()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(LunarMonHorizons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(SKY_FRAGMENT);
            entries.accept(ICE_FEATHER);
        });
    }
}
