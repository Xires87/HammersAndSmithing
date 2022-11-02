package net.fryc.hammersandtables;

import net.fabricmc.api.ModInitializer;
import net.fryc.craftingmanipulator.rules.RecipeBlockingRules;
import net.fryc.craftingmanipulator.rules.StandNearBlockRBR;
import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.items.ModItems;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.fryc.hammersandtables.villagers.ModTradeOffers;
import net.fryc.hammersandtables.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HammersAndTables implements ModInitializer {
	public static final String MOD_ID = "hammersandtables";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	StandNearBlockRBR COPPER = new StandNearBlockRBR("Workshop: Copper Smithing Table", ModItemTags.NEEDS_COPPER_SMITHING_TABLE, ModBlockTags.TABLES);
	StandNearBlockRBR IRON = new StandNearBlockRBR("Workshop: Iron Smithing Table", ModItemTags.NEEDS_IRON_SMITHING_TABLE, ModBlockTags.IRON_TABLES);
	StandNearBlockRBR GOLD = new StandNearBlockRBR("Workshop: Golden Smithing Table", ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, ModBlockTags.GOLDEN_TABLES);
	StandNearBlockRBR DIAMOND = new StandNearBlockRBR("Workshop: Diamond Smithing Table", ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, ModBlockTags.DIAMOND_TABLES);
	RecipeBlockingRules VANILLA_GOLDEN_ITEMS = new RecipeBlockingRules("Recipe disabled by: Hammers and Smithing", ModItemTags.VANILLA_GOLDEN_ITEMS);
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerAllScreenHandlers();

		ModTradeOffers.registerModTradeOffers();
	}
}
