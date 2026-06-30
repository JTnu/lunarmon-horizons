package lunarmonhorizons;

import lunarmonhorizons.block.ModBlocks;
import lunarmonhorizons.block.entity.ModBlockEntities;
import lunarmonhorizons.item.ModItemGroups;
import lunarmonhorizons.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LunarMonHorizons implements ModInitializer {
	public static final String MOD_ID = "lunarmon-horizons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();

	}
}
