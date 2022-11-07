package net.fryc.hammersandtables.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "hammersandtables")
public class HammersAndTablesConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean isTooltipsEnabled = true;
    @ConfigEntry.Gui.Tooltip
    public boolean isCopperRecipeBlocked = true;
    @ConfigEntry.Gui.Tooltip
    public boolean isIronRecipeBlocked = true;
    @ConfigEntry.Gui.Tooltip
    public boolean isGoldRecipeBlocked = true;
    @ConfigEntry.Gui.Tooltip
    public boolean isDiamondRecipeBlocked = true;
    @ConfigEntry.Gui.Tooltip
    public boolean isTradeOffersModified = true;
    @ConfigEntry.Gui.Tooltip
    public boolean forceModifiedTradeOffers = false;
}
