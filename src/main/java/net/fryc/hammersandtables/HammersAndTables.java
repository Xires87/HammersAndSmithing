package net.fryc.hammersandtables;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fryc.craftingmanipulator.rules.RecipeBlockingRules;
import net.fryc.craftingmanipulator.rules.StandNearBlockRBR;
import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.config.HammersAndTablesConfig;
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

	public static HammersAndTablesConfig config;
	String[] tooltips;
	@Override
	public void onInitialize() {
		//config
		AutoConfig.register(HammersAndTablesConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(HammersAndTablesConfig.class).getConfig();
		if(config.isTooltipsEnabled){
			tooltips = new String[]{"Workshop: Copper Smithing Table", "Workshop: Iron Smithing Table", "Workshop: Golden Smithing Table", "Workshop: Diamond Smithing Table"};
		}
		else{
			tooltips = new String[]{"", "", "", ""};
		}


		//blocking recipes with Crafting Manipulator
		if(config.isCopperRecipeBlocked){
			StandNearBlockRBR COPPER = new StandNearBlockRBR(tooltips[0], ModItemTags.NEEDS_COPPER_SMITHING_TABLE, ModBlockTags.TABLES);
		}
		if(config.isIronRecipeBlocked){
			StandNearBlockRBR IRON = new StandNearBlockRBR(tooltips[1], ModItemTags.NEEDS_IRON_SMITHING_TABLE, ModBlockTags.IRON_TABLES);
		}
		if(config.isGoldRecipeBlocked){
			StandNearBlockRBR GOLD = new StandNearBlockRBR(tooltips[2], ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, ModBlockTags.GOLDEN_TABLES);
		}
		if(config.isDiamondRecipeBlocked){
			StandNearBlockRBR DIAMOND = new StandNearBlockRBR(tooltips[3], ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, ModBlockTags.DIAMOND_TABLES);
		}
		RecipeBlockingRules VANILLA_GOLDEN_ITEMS = new RecipeBlockingRules("Recipe disabled by: Hammers and Smithing", ModItemTags.VANILLA_GOLDEN_ITEMS);


		//other
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerAllScreenHandlers();

		if(config.isTradeOffersModified){
			ModTradeOffers.registerModTradeOffers();
		}
	}
}
