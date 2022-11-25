package net.fryc.hammersandtables.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "hammersandtables")
public class HammersAndTablesConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isTooltipsEnabled = true;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isCopperRecipeBlocked = true;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isIronRecipeBlocked = true;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isGoldRecipeBlocked = true;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("recipes")
    @ConfigEntry.Gui.RequiresRestart
    public boolean isDiamondRecipeBlocked = true;
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForArmorer = true;
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForToolsmith = true;
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForWeaponsmith = true;
    @ConfigEntry.Category("trades")
    @ConfigEntry.Gui.RequiresRestart
    public boolean modifyTradeOffersForLibrarian = false;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("trades")
    public boolean forceModifiedTradeOffers = false;
}
