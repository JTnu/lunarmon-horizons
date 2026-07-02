package lunarmonhorizons.block.entity.logic;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;

public class RayquazaLogic {

    public static void trigger(ServerLevel level, BlockPos pos) {

        var species = PokemonSpecies.getByName("rayquaza");

        if (species == null) {
            System.out.println("Rayquaza species not found"); // Temp Debug | Incorrect Species //
            return;
        }

        Pokemon pokemon = species.create(70);

        PokemonEntity entity = new PokemonEntity(level, pokemon, com.cobblemon.mod.common.CobblemonEntities.POKEMON);

        Vec3 spawnPos = Vec3.atCenterOf(pos);
        entity.moveTo(
                spawnPos.x,
                spawnPos.y + 2,
                spawnPos.z,
                level.random.nextFloat() * 360F,
                0
        );

        level.addFreshEntity(entity);

        System.out.println("Rayquaza successfully spawned!"); // Temp Debug | Logic Success //
    }
}