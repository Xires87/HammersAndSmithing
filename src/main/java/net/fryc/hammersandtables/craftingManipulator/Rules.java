package net.fryc.hammersandtables.craftingManipulator;

import net.fryc.craftingmanipulator.rules.oncraft.PlaySoundOCR;
import net.fryc.craftingmanipulator.rules.recipeblocking.StandNearBlockRBR;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.screen.BlastFurnaceScreenHandler;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.sound.SoundEvents;

public class Rules {

    public static StandNearBlockRBR COPPER = new StandNearBlockRBR(ModItemTags.NEEDS_COPPER_SMITHING_TABLE, ModBlockTags.TABLES);
    public static StandNearBlockRBR IRON = new StandNearBlockRBR(ModItemTags.NEEDS_IRON_SMITHING_TABLE, ModBlockTags.IRON_TABLES);
    public static StandNearBlockRBR GOLD = new StandNearBlockRBR(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE, ModBlockTags.GOLDEN_TABLES);
    public static StandNearBlockRBR DIAMOND = new StandNearBlockRBR(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE, ModBlockTags.DIAMOND_TABLES);
    public static StandNearBlockRBR VANILLA_GOLDEN = new StandNearBlockRBR(ModItemTags.VANILLA_GOLDEN_ITEMS, ModBlockTags.PIGLINS_FORGE);

    public static void enableCraftingManipulatorRules(){

        // enabling/disabling rules
        COPPER.isEnabled = HammersAndTables.config.isCopperRecipeBlocked;
        IRON.isEnabled = HammersAndTables.config.isIronRecipeBlocked;
        GOLD.isEnabled = HammersAndTables.config.isGoldRecipeBlocked;
        DIAMOND.isEnabled = HammersAndTables.config.isDiamondRecipeBlocked;
        VANILLA_GOLDEN.isEnabled = HammersAndTables.config.isVanillaGoldenRecipeBlocked;

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
