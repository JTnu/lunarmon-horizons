package lunarmonhorizons;

import lunarmonhorizons.block.ModBlocks;
import lunarmonhorizons.block.entities.ModBlockEntities;
import lunarmonhorizons.item.ModItemGroups;
import lunarmonhorizons.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LunarMonHorizons implements ModInitializer {
	public static final String MOD_ID = "lunarmon-horizons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static GameRules.Key<GameRules.BooleanValue> SCAN_ANCHORS = GameRuleRegistry
			.register("scanAnchors", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(false));

	/**
	 * Helper method to create Mod's ids
	 */
	public static ResourceLocation of(String path){
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();

	}
}
