package lunarmonhorizons.block;

import lunarmonhorizons.LunarMonHorizons;
import lunarmonhorizons.block.custom.PedestalBlock;
import lunarmonhorizons.block.custom.RayquazaPedestalBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {

    public static final Block PEDESTAL_BASE = registerBlock(
            "pedestal_base",
            new PedestalBlock(BlockBehaviour.Properties.of().noOcclusion())
    );

    public static final Block RAYQUAZA_PEDESTAL = registerBlock(
            "rayquaza_pedestal",
            new RayquazaPedestalBlock(BlockBehaviour.Properties.of().noOcclusion())
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);

        return Registry.register(
                BuiltInRegistries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(LunarMonHorizons.MOD_ID, name),
                block
        );
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(LunarMonHorizons.MOD_ID, name),
                new BlockItem(block, new Item.Properties())
        );
    }

    public static void registerModBlocks() {
        LunarMonHorizons.LOGGER.info("Registering Mod Blocks for " + LunarMonHorizons.MOD_ID);
    }
}