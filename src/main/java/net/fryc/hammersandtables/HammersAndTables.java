package net.fryc.hammersandtables;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fryc.craftingmanipulator.conditions.PressedKey;
import net.fryc.craftingmanipulator.rules.recipeblocking.StandNearBlockRBR;
import net.fryc.craftingmanipulator.rules.tooltips.TooltipRules;
import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.config.HammersAndTablesConfig;
import net.fryc.hammersandtables.items.ModItems;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.fryc.hammersandtables.villagers.ModTradeOffers;
import net.fryc.hammersandtables.screen.ModScreenHandlers;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HammersAndTables implements ModInitializer {
	public static final String MOD_ID = "hammersandtables";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static HammersAndTablesConfig config;

	private final Formatting[] requirementsTooltip = new Formatting[]{Formatting.YELLOW};
	private final Formatting[] tooltip = new Formatting[]{Formatting.RED};

	@Override
	public void onInitialize() {
		//config
		AutoConfig.register(HammersAndTablesConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(HammersAndTablesConfig.class).getConfig();

		//tooltip for golden items
		if(config.isTooltipsForGoldenItemsEnabled){
			TooltipRules LOVED_BY_PIGLINS = new TooltipRules(ItemTags.PIGLIN_LOVED, "Loved by Piglins");
			LOVED_BY_PIGLINS.tooltipFormatting = new Formatting[]{Formatting.BLUE};
		}

		//blocking recipes with Crafting Manipulator
		if(config.isCopperRecipeBlocked){
			StandNearBlockRBR COPPER = new StandNearBlockRBR(ModItemTags.NEEDS_COPPER_SMITHING_TABLE, ModBlockTags.TABLES);
			if(config.isTooltipsEnabled){
				TooltipRules COPPER_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_COPPER_SMITHING_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Copper Smithing Table");
				COPPER_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
				COPPER_TOOLTIP.tooltipFormatting = requirementsTooltip;
			}
		}
		if(config.isIronRecipeBlocked){
			StandNearBlockRBR IRON = new StandNearBlockRBR(ModItemTags.NEEDS_IRON_SMITHING_TABLE, ModBlockTags.IRON_TABLES);
			if(config.isTooltipsEnabled){
				TooltipRules IRON_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_IRON_SMITHING_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Iron Smithing Table");
				IRON_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
				IRON_TOOLTIP.tooltipFormatting = requirementsTooltip;
			}
		}
		if(config.isGoldRecipeBlocked){
			StandNearBlockRBR GOLD = new StandNearBlockRBR(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, ModBlockTags.GOLDEN_TABLES);
			if(config.isTooltipsEnabled){
				TooltipRules GOLD_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Golden Smithing Table");
				GOLD_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
				GOLD_TOOLTIP.tooltipFormatting = requirementsTooltip;
			}
		}
		if(config.isDiamondRecipeBlocked){
			StandNearBlockRBR DIAMOND = new StandNearBlockRBR(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, ModBlockTags.DIAMOND_TABLES);
			if(config.isTooltipsEnabled){
				TooltipRules DIAMOND_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Diamond Smithing Table");
				DIAMOND_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
				DIAMOND_TOOLTIP.tooltipFormatting = requirementsTooltip;
			}
		}
		if(config.isVanillaGoldenRecipeBlocked){
			StandNearBlockRBR VANILLA_GOLDEN = new StandNearBlockRBR(ModItemTags.VANILLA_GOLDEN_ITEMS, ModBlockTags.PIGLINS_FORGE);
			if(config.isTooltipsEnabled){
				TooltipRules VANILLA_GOLDEN_TOOLTIP = new TooltipRules(ModItemTags.VANILLA_GOLDEN_ITEMS, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Piglins Forge");
				VANILLA_GOLDEN_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
				VANILLA_GOLDEN_TOOLTIP.tooltipFormatting = requirementsTooltip;
			}
		}

		//other
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerAllScreenHandlers();

		ModTradeOffers.registerModTradeOffers();

		//creative
		ItemGroup HAMMERS_AND_SMITHING = FabricItemGroup.builder(new Identifier(MOD_ID, "hammers_and_smithing_item_group"))
				.displayName(Text.literal("Hammers and Smithing"))
				.icon(() -> new ItemStack(ModBlocks.COPPER_TABLE))
				.entries((enabledFeatures, entries) -> {
					//tables
					entries.add(ModBlocks.COPPER_TABLE);
					entries.add(ModBlocks.IRON_TABLE);
					entries.add(ModBlocks.GOLD_TABLE);
					entries.add(ModBlocks.DIAMOND_TABLE);
					entries.add(ModBlocks.PIGLINS_FORGE);

					//hammers
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
					
				})
				.build();

	}
}
