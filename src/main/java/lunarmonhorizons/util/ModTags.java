package lunarmonhorizons.util;

import lunarmonhorizons.LunarMonHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(LunarMonHorizons.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> SUMMONING_ITEMS = createTag("summoning_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(LunarMonHorizons.MOD_ID, name));
        }
    }
}
