package net.fryc.hammersandtables.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "hammersandtables")
public class HammersAndTablesConfig implements ConfigData {
    @ConfigEntry.Category("sounds")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Play smithing sounds when crafting items that require smithing table [Restart Required]")
    public boolean isSmithingSoundWhenCraftingEnabled = true;

    @ConfigEntry.Category("sounds")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Play extinguish sound when smelting [Restart Required]")
    public boolean isSmeltingSoundWhenCraftingEnabled = true;

    @Comment("Copper items cannot be crafted if you don't stand near Copper Smithing Table (or better smithing table)")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isCopperRecipeBlocked = true;
    @Comment("Iron items cannot be crafted if you don't stand near Iron Smithing Table (or better smithing table)")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isIronRecipeBlocked = true;
    @Comment("Golden items cannot be crafted if you don't stand near Golden Smithing Table (or better smithing table)")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isGoldRecipeBlocked = true;
    @Comment("Diamond items cannot be crafted if you don't stand near Diamond Smithing Table")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isDiamondRecipeBlocked = true;
    @Comment("Vanilla golden items cannot be crafted if you don't stand near Piglins Forge")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isVanillaGoldenRecipeBlocked = true;

    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForArmorer = true;

    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForToolsmith = true;

    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForWeaponsmith = true;
    @Comment("Modify trade offers for Librarian (Librarian won't sell enchanted book on first level) [Restart required]")
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForLibrarian = false;

}
