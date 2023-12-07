package net.fryc.hammersandtables.craftingManipulator;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.craftingmanipulator.conditions.PressedKey;
import net.fryc.craftingmanipulator.rules.tooltips.TooltipRules;
import net.fryc.hammersandtables.HammersAndTablesClient;
import net.fryc.hammersandtables.network.SynchronizedConfigOptions;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

@Environment(EnvType.CLIENT)
public class ClientRules {

    private static final Text CRAFTING_REQUIREMENTS = Text.translatable("text.craftingmanipulator.crafting_requirements").formatted(Formatting.YELLOW);
    private static TooltipRules COPPER_TOOLTIP;
    private static TooltipRules IRON_TOOLTIP;
    private static TooltipRules GOLD_TOOLTIP;
    private static TooltipRules DIAMOND_TOOLTIP;
    private static TooltipRules VANILLA_GOLDEN_TOOLTIP;

    public static void enableCraftingManipulatorClientRules(){
        //tooltip for golden items
        if(HammersAndTablesClient.config.isTooltipsForGoldenItemsEnabled){
            TooltipRules LOVED_BY_PIGLINS = new TooltipRules(ItemTags.PIGLIN_LOVED, Text.translatable("text.craftingmanipulator.piglin_loved").formatted(Formatting.BLUE));
        }

        if(HammersAndTablesClient.config.isCraftingRequirementsTooltipsEnabled){
            COPPER_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_COPPER_SMITHING_TABLE, CRAFTING_REQUIREMENTS, PressedKey.SHIFT, Text.translatable("text.craftingmanipulator.copper_workshop_required").formatted(Formatting.RED));
            IRON_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_IRON_SMITHING_TABLE, CRAFTING_REQUIREMENTS, PressedKey.SHIFT, Text.translatable("text.craftingmanipulator.iron_workshop_required").formatted(Formatting.RED));
            GOLD_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, CRAFTING_REQUIREMENTS, PressedKey.SHIFT, Text.translatable("text.craftingmanipulator.golden_workshop_required").formatted(Formatting.RED));
            DIAMOND_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, CRAFTING_REQUIREMENTS, PressedKey.SHIFT, Text.translatable("text.craftingmanipulator.diamond_workshop_required").formatted(Formatting.RED));
            VANILLA_GOLDEN_TOOLTIP = new TooltipRules(ModItemTags.VANILLA_GOLDEN_ITEMS, CRAFTING_REQUIREMENTS, PressedKey.SHIFT, Text.translatable("text.craftingmanipulator.piglin_workshop_required").formatted(Formatting.RED));

        }
     }

     public static void setRulesStatus(){
        if(COPPER_TOOLTIP != null){
            COPPER_TOOLTIP.isEnabled = SynchronizedConfigOptions.isCopperRecipeBlocked;
            IRON_TOOLTIP.isEnabled = SynchronizedConfigOptions.isIronRecipeBlocked;
            GOLD_TOOLTIP.isEnabled = SynchronizedConfigOptions.isGoldRecipeBlocked;
            DIAMOND_TOOLTIP.isEnabled = SynchronizedConfigOptions.isDiamondRecipeBlocked;
            VANILLA_GOLDEN_TOOLTIP.isEnabled = SynchronizedConfigOptions.isVanillaGoldenRecipeBlocked;
        }
     }

}
