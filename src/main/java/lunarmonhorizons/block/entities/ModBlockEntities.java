package lunarmonhorizons.block.entities;

import lunarmonhorizons.LunarMonHorizons;
import lunarmonhorizons.block.ModBlocks;
import lunarmonhorizons.block.entities.anchor.SpawningAnchorBlockEntity;
import lunarmonhorizons.block.entities.pedestals.basic.BasicPedestalBlockEntity;
import lunarmonhorizons.block.entities.pedestals.summoning.SimpleSummoningPedestalBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static final BlockEntityType<BasicPedestalBlockEntity> PEDESTAL_BE =
            registerBE(
                    "pedestal",
                    BlockEntityType.Builder.of(BasicPedestalBlockEntity::new,
                            ModBlocks.PEDESTAL_BASE
                    ).build(null)
            );

    public static final BlockEntityType<SpawningAnchorBlockEntity> SPAWNING_ANCHOR_BE =
            registerBE(
                    "spawning_anchor",
                    BlockEntityType.Builder.of(SpawningAnchorBlockEntity::new, ModBlocks.SPAWNING_ANCHOR).build(null)
            );

    public static final BlockEntityType<SimpleSummoningPedestalBlockEntity> SPAWNING_PEDESTAL_BE =
            registerBE(
                    "spawning_pedestal",
                    BlockEntityType.Builder.of(SimpleSummoningPedestalBlockEntity::new, ModBlocks.RAYQUAZA_PEDESTAL).build(null)
            );

    private static <T extends BlockEntity> BlockEntityType<T> registerBE(String id, BlockEntityType<T> type){
        return Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                LunarMonHorizons.of(id),
                type
        );
    }

    public static void registerBlockEntities() {
        LunarMonHorizons.LOGGER.info("Registering block entities for {}", LunarMonHorizons.MOD_ID);
    }
}