package lunarmonhorizons.item;

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
    public static final ResourceKey<CreativeModeTab> HORIZONS_ITEMS_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath("lunarmon-horizons", "horizons_items")
    );

    public static final CreativeModeTab HORIZONS_ITEMS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SKY_FRAGMENT))
            .title(Component.translatable("itemGroup.lunarmon-horizons.horizons_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.SKY_FRAGMENT);
                output.accept(ModItems.ICE_FEATHER);
            })
            .build();

    public static void registerItemGroups() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, HORIZONS_ITEMS_KEY, HORIZONS_ITEMS_GROUP);
    }
}
