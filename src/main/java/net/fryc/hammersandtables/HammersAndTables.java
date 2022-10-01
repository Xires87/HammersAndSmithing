package net.fryc.hammersandtables;

import net.fabricmc.api.ModInitializer;
import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.gamerules.ModGameRules;
import net.fryc.hammersandtables.items.ModItems;
import net.fryc.hammersandtables.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HammersAndTables implements ModInitializer {
	public static final String MOD_ID = "hammersandtables";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerAllScreenHandlers();

		ModGameRules.registerGameRules();
	}
}
