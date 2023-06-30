package net.fryc.hammersandtables.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "hammersandtables")
public class HammersAndTablesConfig implements ConfigData {
    @Comment("Adds tooltips telling you which smithing table is required to craft item")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("tooltips")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isTooltipsEnabled = true;
    @Comment("Adds tooltips for items that can be used to trade with piglins [Restart Required]")
    @ConfigEntry.Category("tooltips")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isTooltipsForGoldenItemsEnabled = true;
    @ConfigEntry.Category("tooltips")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Play smithing sounds when crafting items that require smithing table, and extinguish sound when smelting [Restart Required]")
    public boolean isSoundsWhenCraftingEnabled = true;

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
    @Comment("Modifies trade offers for Armorer, Toolsmith and Weaponsmith and prevents other mods from adding new trade offers (or changing existing ones) for ALL professions (!!! Trade offers from other mods will not work !!!)")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("trades")
    public boolean forceModifiedTradeOffers = false;
}
