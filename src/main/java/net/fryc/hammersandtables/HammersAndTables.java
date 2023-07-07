package net.fryc.hammersandtables;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.config.HammersAndTablesConfig;
import net.fryc.hammersandtables.craftingManipulator.Rules;
import net.fryc.hammersandtables.items.ModItems;
import net.fryc.hammersandtables.screen.ModScreenHandlers;
import net.fryc.hammersandtables.villagers.ModTradeOffers;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HammersAndTables implements ModInitializer {
	public static final String MOD_ID = "hammersandtables";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static HammersAndTablesConfig config;

	public static final RegistryKey<ItemGroup> HAMMERS_AND_SMITHING = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "hammers_and_smithing_item_group"));
	// todo tekstury, testy, lang i loot table

	@Override
	public void onInitialize() {
		//config
		AutoConfig.register(HammersAndTablesConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(HammersAndTablesConfig.class).getConfig();

		Rules.enableCraftingManipulatorRules();

		//other
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerScreenHandlers();

		ModTradeOffers.registerModTradeOffers();


		//Item Group
		Registry.register(Registries.ITEM_GROUP, HAMMERS_AND_SMITHING, FabricItemGroup.builder()
				.icon(() -> new ItemStack(ModBlocks.COPPER_TABLE))
				.displayName(Text.literal("Hammers and Smithing"))
				.entries((enabledFeatures, entries) -> {
					//tables
					entries.add(ModBlocks.COPPER_TABLE);
					entries.add(ModBlocks.IRON_TABLE);
					entries.add(ModBlocks.GOLD_TABLE);
					entries.add(ModBlocks.DIAMOND_TABLE);
					entries.add(ModBlocks.PIGLINS_FORGE);

					//hammers
					entries.add(ModItems.SHINY_GOLDEN_HAMMER);
					entries.add(ModItems.COPPER_HAMMER);
					entries.add(ModItems.NUGGET_COPPER_HAMMER);
					entries.add(ModItems.INGOT_COPPER_HAMMER);

					entries.add(ModItems.IRON_HAMMER);
					entries.add(ModItems.NUGGET_IRON_HAMMER);
					entries.add(ModItems.INGOT_IRON_HAMMER);

					entries.add(ModItems.GOLDEN_HAMMER);
					entries.add(ModItems.DIAMOND_GOLDEN_HAMMER);

					entries.add(ModItems.DIAMOND_HAMMER);
					entries.add(ModItems.NETHERITE_HAMMER);

					//copper
					entries.add(ModItems.COPPER_PICKAXE);
					entries.add(ModItems.COPPER_AXE);
					entries.add(ModItems.COPPER_SHOVEL);
					entries.add(ModItems.COPPER_HOE);
					entries.add(ModItems.COPPER_SWORD);
					entries.add(ModItems.COPPER_HELMET);
					entries.add(ModItems.COPPER_CHESTPLATE);
					entries.add(ModItems.COPPER_LEGGINGS);
					entries.add(ModItems.COPPER_BOOTS);

					//nugget copper
					entries.add(ModItems.NUGGET_COPPER_PICKAXE);
					entries.add(ModItems.NUGGET_COPPER_AXE);
					entries.add(ModItems.NUGGET_COPPER_SHOVEL);
					entries.add(ModItems.NUGGET_COPPER_HOE);
					entries.add(ModItems.NUGGET_COPPER_SWORD);
					entries.add(ModItems.NUGGET_COPPER_HELMET);
					entries.add(ModItems.NUGGET_COPPER_CHESTPLATE);
					entries.add(ModItems.NUGGET_COPPER_LEGGINGS);
					entries.add(ModItems.NUGGET_COPPER_BOOTS);

					//ingot copper
					entries.add(ModItems.INGOT_COPPER_PICKAXE);
					entries.add(ModItems.INGOT_COPPER_AXE);
					entries.add(ModItems.INGOT_COPPER_SHOVEL);
					entries.add(ModItems.INGOT_COPPER_HOE);
					entries.add(ModItems.INGOT_COPPER_SWORD);
					entries.add(ModItems.INGOT_COPPER_HELMET);
					entries.add(ModItems.INGOT_COPPER_CHESTPLATE);
					entries.add(ModItems.INGOT_COPPER_LEGGINGS);
					entries.add(ModItems.INGOT_COPPER_BOOTS);

					//nugget iron
					entries.add(ModItems.NUGGET_IRON_PICKAXE);
					entries.add(ModItems.NUGGET_IRON_AXE);
					entries.add(ModItems.NUGGET_IRON_SHOVEL);
					entries.add(ModItems.NUGGET_IRON_HOE);
					entries.add(ModItems.NUGGET_IRON_SWORD);
					entries.add(ModItems.NUGGET_IRON_HELMET);
					entries.add(ModItems.NUGGET_IRON_CHESTPLATE);
					entries.add(ModItems.NUGGET_IRON_LEGGINGS);
					entries.add(ModItems.NUGGET_IRON_BOOTS);

					//ingot iron
					entries.add(ModItems.INGOT_IRON_PICKAXE);
					entries.add(ModItems.INGOT_IRON_AXE);
					entries.add(ModItems.INGOT_IRON_SHOVEL);
					entries.add(ModItems.INGOT_IRON_HOE);
					entries.add(ModItems.INGOT_IRON_SWORD);
					entries.add(ModItems.INGOT_IRON_HELMET);
					entries.add(ModItems.INGOT_IRON_CHESTPLATE);
					entries.add(ModItems.INGOT_IRON_LEGGINGS);
					entries.add(ModItems.INGOT_IRON_BOOTS);

					//gold
					entries.add(ModItems.GOLDEN_PICKAXE);
					entries.add(ModItems.GOLDEN_AXE);
					entries.add(ModItems.GOLDEN_SHOVEL);
					entries.add(ModItems.GOLDEN_HOE);
					entries.add(ModItems.GOLDEN_SWORD);
					entries.add(ModItems.GOLDEN_HELMET);
					entries.add(ModItems.GOLDEN_CHESTPLATE);
					entries.add(ModItems.GOLDEN_LEGGINGS);
					entries.add(ModItems.GOLDEN_BOOTS);

					//diamond gold
					entries.add(ModItems.DIAMOND_GOLDEN_PICKAXE);
					entries.add(ModItems.DIAMOND_GOLDEN_AXE);
					entries.add(ModItems.DIAMOND_GOLDEN_SHOVEL);
					entries.add(ModItems.DIAMOND_GOLDEN_HOE);
					entries.add(ModItems.DIAMOND_GOLDEN_SWORD);
					entries.add(ModItems.DIAMOND_GOLDEN_HELMET);
					entries.add(ModItems.DIAMOND_GOLDEN_CHESTPLATE);
					entries.add(ModItems.DIAMOND_GOLDEN_LEGGINGS);
					entries.add(ModItems.DIAMOND_GOLDEN_BOOTS);

					//bone armor
					entries.add(ModItems.BONE_HELMET);
					entries.add(ModItems.BONE_CHESTPLATE);
					entries.add(ModItems.BONE_LEGGINGS);
					entries.add(ModItems.BONE_BOOTS);

					//templates
					entries.add(ModItems.DIAMOND_REINFORCEMENT_SMITHING_TEMPLATE);
					entries.add(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE);
					entries.add(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE);

				})
				.build());


	}
}
