package net.fryc.hammersandtables.craftingManipulator;

import net.fryc.craftingmanipulator.registry.CMRegistries;
import net.fryc.craftingmanipulator.rules.oncraft.PlaySoundOCR;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

public class Rules {

    public static final Text COPPER_RULE_TOOLTIP = Text.translatable("text.hammersandtables.copperRule");
    public static final Text IRON_RULE_TOOLTIP = Text.translatable("text.hammersandtables.ironRule");
    public static final Text GOLD_RULE_TOOLTIP = Text.translatable("text.hammersandtables.goldRule");
    public static final Text DIAMOND_RULE_TOOLTIP = Text.translatable("text.hammersandtables.diamondRule");
    public static final Text VANILLA_GOLD_RULE_TOOLTIP = Text.translatable("text.hammersandtables.vanillaGoldRule");

    public static final StandNearBlockWithTooltipRBR COPPER = (StandNearBlockWithTooltipRBR) CMRegistries.registerCraftingRule("hammersandtables_copperRule",
            new StandNearBlockWithTooltipRBR(ModItemTags.NEEDS_COPPER_SMITHING_TABLE, ModBlockTags.TABLES, COPPER_RULE_TOOLTIP, RuleTier.COPPER));
    public static final StandNearBlockWithTooltipRBR IRON = (StandNearBlockWithTooltipRBR) CMRegistries.registerCraftingRule("hammersandtables_ironRule",
            new StandNearBlockWithTooltipRBR(ModItemTags.NEEDS_IRON_SMITHING_TABLE, ModBlockTags.IRON_TABLES, IRON_RULE_TOOLTIP, RuleTier.IRON));
    public static final StandNearBlockWithTooltipRBR GOLD = (StandNearBlockWithTooltipRBR) CMRegistries.registerCraftingRule("hammersandtables_goldRule",
            new StandNearBlockWithTooltipRBR(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, ModBlockTags.GOLDEN_TABLES, GOLD_RULE_TOOLTIP, RuleTier.GOLD));
    public static final StandNearBlockWithTooltipRBR DIAMOND = (StandNearBlockWithTooltipRBR) CMRegistries.registerCraftingRule("hammersandtables_diamondRule",
            new StandNearBlockWithTooltipRBR(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, ModBlockTags.DIAMOND_TABLES, DIAMOND_RULE_TOOLTIP, RuleTier.DIAMOND));
    public static final StandNearBlockWithTooltipRBR VANILLA_GOLDEN = (StandNearBlockWithTooltipRBR) CMRegistries.registerCraftingRule("hammersandtables_vanillaGoldRule",
            new StandNearBlockWithTooltipRBR(ModItemTags.VANILLA_GOLDEN_ITEMS, ModBlockTags.PIGLINS_FORGE, VANILLA_GOLD_RULE_TOOLTIP, RuleTier.NONE));

    public static final PlaySoundOCR SMITHING_SOUNDS = (PlaySoundOCR) CMRegistries.registerCraftingRule("hammersandtables_smithingSoundsRule",
            new PlaySoundOCR(ModItemTags.PLAYING_SMITHING_SOUND_ON_CRAFT, SoundEvents.BLOCK_SMITHING_TABLE_USE, 0.65f, 0.9f));
    public static final PlaySmeltingSoundOCR SMELTING_SOUNDS = (PlaySmeltingSoundOCR) CMRegistries.registerCraftingRule("hammersandtables_smeltingSoundsRule",
            new PlaySmeltingSoundOCR(ModItemTags.PLAYING_SMELTING_SOUND_ON_CRAFT, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 0.65f, 0.74f));

    public static void enableCraftingManipulatorRules(){

        // enabling/disabling rules
        COPPER.enabled = HammersAndTables.config.isCopperRecipeBlocked;
        IRON.enabled = HammersAndTables.config.isIronRecipeBlocked;
        GOLD.enabled = HammersAndTables.config.isGoldRecipeBlocked;
        DIAMOND.enabled = HammersAndTables.config.isDiamondRecipeBlocked;
        VANILLA_GOLDEN.enabled = HammersAndTables.config.isVanillaGoldenRecipeBlocked;

        // sounds
        SMITHING_SOUNDS.enabled = HammersAndTables.config.isSmithingSoundWhenCraftingEnabled;
        SMELTING_SOUNDS.enabled = HammersAndTables.config.isSmeltingSoundWhenCraftingEnabled;
    }
}
