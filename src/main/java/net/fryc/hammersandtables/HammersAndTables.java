package net.fryc.hammersandtables;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.config.HammersAndTablesConfig;
import net.fryc.hammersandtables.craftingManipulator.Rules;
import net.fryc.hammersandtables.items.ModItems;
import net.fryc.hammersandtables.items.components.ModComponents;
import net.fryc.hammersandtables.loot.ModLootTables;
import net.fryc.hammersandtables.recipes.ModRecipeSerializers;
import net.fryc.hammersandtables.screen.ModScreenHandlers;
import net.fryc.hammersandtables.villagers.ModTradeOffers;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HammersAndTables implements ModInitializer {
	public static final String MOD_ID = "hammersandtables";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static HammersAndTablesConfig config;

	public static final RegistryKey<ItemGroup> HAMMERS_AND_SMITHING = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "hammers_and_smithing_item_group"));

	@Override
	public void onInitialize() {
		//config
		AutoConfig.register(HammersAndTablesConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(HammersAndTablesConfig.class).getConfig();

		Rules.enableCraftingManipulatorRules();

		//other
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRecipeSerializers.registerModRecipeSerializers();
		ModScreenHandlers.registerScreenHandlers();

		ModTradeOffers.registerModTradeOffers();

		ModComponents.registerModComponents();

		ModLootTables.modifyLoot();

	}
}
