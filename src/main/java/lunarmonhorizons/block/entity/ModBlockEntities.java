package lunarmonhorizons.block.entity;

import lunarmonhorizons.LunarMonHorizons;
import lunarmonhorizons.block.ModBlocks;
import lunarmonhorizons.block.entity.custom.PedestalBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(
                    BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    ResourceLocation.fromNamespaceAndPath(LunarMonHorizons.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.of(PedestalBlockEntity::new,
                            ModBlocks.PEDESTAL_BASE,
                            ModBlocks.RAYQUAZA_PEDESTAL
                    ).build(null)
            );

    public static void registerBlockEntities() {
        LunarMonHorizons.LOGGER.info("Registering block entities for {}", LunarMonHorizons.MOD_ID);
    }
}