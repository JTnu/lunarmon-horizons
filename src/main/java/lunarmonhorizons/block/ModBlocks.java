package lunarmonhorizons.block;

import com.cobblemon.mod.common.CobblemonEntities;
import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import lunarmonhorizons.LunarMonHorizons;
import lunarmonhorizons.block.blocks.pedestals.basic.BasicPedestalBlock;
import lunarmonhorizons.block.blocks.pedestals.summoning.SimpleSummoningPedestalBlock;
import lunarmonhorizons.block.blocks.anchor.SpawningAnchorBlock;
import lunarmonhorizons.block.entities.pedestals.summoning.SimpleSummoningPedestalBlockEntity;
import lunarmonhorizons.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;

public class ModBlocks {

    public static final Block PEDESTAL_BASE = registerBlock(
            "pedestal_base",
            new BasicPedestalBlock(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(-1.0F, 3600000.0F)
                    .noLootTable()
                    .isValidSpawn(Blocks::never)
            )
    );

    public static final Block RAYQUAZA_PEDESTAL = registerSummoningPedestal(
            "rayquaza_pedestal",
            ModItems.SKY_FRAGMENT,
            (SimpleSummoningPedestalBlockEntity blockEntity) -> {
                var species = PokemonSpecies.getByName("rayquaza");
                if (species == null || !(blockEntity.getLevel() instanceof ServerLevel serverLevel)) return;

                Pokemon pokemon = species.create(70);

                PokemonEntity entity = new PokemonEntity(serverLevel, pokemon, CobblemonEntities.POKEMON);

                Vec3 spawnPos = Vec3.atCenterOf(blockEntity.getSpawningPos());
                entity.moveTo(
                        spawnPos.x,
                        spawnPos.y + 2,
                        spawnPos.z,
                        serverLevel.random.nextFloat() * 360F,
                        0
                );

                serverLevel.addFreshEntity(entity);
            }
    );

    public static final Block SPAWNING_ANCHOR = registerBlock(
            "spawning_anchor",
            new SpawningAnchorBlock(BlockBehaviour.Properties.of())
    );

    private static SimpleSummoningPedestalBlock registerSummoningPedestal(String pedestalName, Item requiredItem, Consumer<SimpleSummoningPedestalBlockEntity> summoning) {
        return (SimpleSummoningPedestalBlock) registerBlock(pedestalName, new SimpleSummoningPedestalBlock(
                BlockBehaviour.Properties.of()
                        .strength(-1.0F, 3600000.0F)
                        .noLootTable()
                        .isValidSpawn(Blocks::never),
                requiredItem,
                summoning
        ));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);

        return Registry.register(
                BuiltInRegistries.BLOCK,
                LunarMonHorizons.of(name),
                block
        );
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(
                BuiltInRegistries.ITEM,
                LunarMonHorizons.of(name),
                new BlockItem(block, new Item.Properties())
        );
    }

    public static void registerModBlocks() {
        LunarMonHorizons.LOGGER.info("Registering Mod Blocks for " + LunarMonHorizons.MOD_ID);
    }
}