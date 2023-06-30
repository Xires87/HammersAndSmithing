package net.fryc.hammersandtables.craftingManipulator;

import net.fryc.craftingmanipulator.conditions.PressedKey;
import net.fryc.craftingmanipulator.rules.oncraft.PlaySoundOCR;
import net.fryc.craftingmanipulator.rules.recipeblocking.StandNearBlockRBR;
import net.fryc.craftingmanipulator.rules.tooltips.TooltipRules;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.BlastFurnaceScreenHandler;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Formatting;

public class Rules {

    private static final Formatting[] requirementsTooltip = new Formatting[]{Formatting.YELLOW};
    private static final Formatting[] tooltip = new Formatting[]{Formatting.RED};

    public static void enableCraftingManipulatorRules(){
        //tooltip for golden items
        if(HammersAndTables.config.isTooltipsForGoldenItemsEnabled){
            TooltipRules LOVED_BY_PIGLINS = new TooltipRules(ItemTags.PIGLIN_LOVED, "Loved by Piglins");
            LOVED_BY_PIGLINS.tooltipFormatting = new Formatting[]{Formatting.BLUE};
        }

        //blocking recipes with Crafting Manipulator
        if(HammersAndTables.config.isCopperRecipeBlocked){
            StandNearBlockRBR COPPER = new StandNearBlockRBR(ModItemTags.NEEDS_COPPER_SMITHING_TABLE, ModBlockTags.TABLES);
            if(HammersAndTables.config.isTooltipsEnabled){
                TooltipRules COPPER_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_COPPER_SMITHING_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Copper Smithing Table");
                COPPER_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                COPPER_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }
        if(HammersAndTables.config.isIronRecipeBlocked){
            StandNearBlockRBR IRON = new StandNearBlockRBR(ModItemTags.NEEDS_IRON_SMITHING_TABLE, ModBlockTags.IRON_TABLES);
            if(HammersAndTables.config.isTooltipsEnabled){
                TooltipRules IRON_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_IRON_SMITHING_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Iron Smithing Table");
                IRON_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                IRON_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }
        if(HammersAndTables.config.isGoldRecipeBlocked){
            StandNearBlockRBR GOLD = new StandNearBlockRBR(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, ModBlockTags.GOLDEN_TABLES);
            if(HammersAndTables.config.isTooltipsEnabled){
                TooltipRules GOLD_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Golden Smithing Table");
                GOLD_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                GOLD_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }
        if(HammersAndTables.config.isDiamondRecipeBlocked){
            StandNearBlockRBR DIAMOND = new StandNearBlockRBR(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, ModBlockTags.DIAMOND_TABLES);
            if(HammersAndTables.config.isTooltipsEnabled){
                TooltipRules DIAMOND_TOOLTIP = new TooltipRules(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Diamond Smithing Table");
                DIAMOND_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                DIAMOND_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }
        if(HammersAndTables.config.isVanillaGoldenRecipeBlocked){
            StandNearBlockRBR VANILLA_GOLDEN = new StandNearBlockRBR(ModItemTags.VANILLA_GOLDEN_ITEMS, ModBlockTags.PIGLINS_FORGE);
            if(HammersAndTables.config.isTooltipsEnabled){
                TooltipRules VANILLA_GOLDEN_TOOLTIP = new TooltipRules(ModItemTags.VANILLA_GOLDEN_ITEMS, "Crafting Requirements (SHIFT)", PressedKey.SHIFT, "Workshop: Piglins Forge");
                VANILLA_GOLDEN_TOOLTIP.tooltipWhenKeyPressedFormatting = tooltip;
                VANILLA_GOLDEN_TOOLTIP.tooltipFormatting = requirementsTooltip;
            }
        }

        // sounds
        if(HammersAndTables.config.isSoundsWhenCraftingEnabled){
            PlaySoundOCR SMITHING_SOUNDS = new PlaySoundOCR(ModItemTags.PLAYING_SMITHING_SOUND_ON_CRAFT, SoundEvents.BLOCK_SMITHING_TABLE_USE, 0.65f, 0.9f);
            SMITHING_SOUNDS.getSelectedScreenHandlers().add(CraftingScreenHandler.class);
            PlaySoundOCR SMELTING_SOUNDS = new PlaySoundOCR(ModItemTags.PLAYING_SMELTING_SOUND_ON_CRAFT, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 0.65f, 0.74f);
            SMELTING_SOUNDS.getSelectedScreenHandlers().add(BlastFurnaceScreenHandler.class);
            SMELTING_SOUNDS.getSelectedScreenHandlers().add(FurnaceScreenHandler.class);
        }
    }
}
