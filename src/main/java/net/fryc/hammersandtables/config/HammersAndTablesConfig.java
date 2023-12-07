package net.fryc.hammersandtables.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "hammersandtables")
public class HammersAndTablesConfig implements ConfigData {
    @ConfigEntry.Category("sounds")
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

    //Sword Parry compat
    @Comment("Options below don't do anything unless Sword Parry is installed")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("hammer")
    @ConfigEntry.BoundedDiscrete(max = 30, min = 0)
    public int hammerParryTicks = 1;

    @Comment("% of damage TAKEN (not reduced) after blocking melee attack: the higher this value is, the more damage player takes when blocking")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("hammer")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int hammerBlockMeleeDamageTaken = 23;

    @Comment("% of damage TAKEN (not reduced) after blocking projectile: the higher this value is, the more damage player takes when blocking")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("hammer")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int hammerBlockArrowDamageTaken = 75;

    @ConfigEntry.Category("hammer")
    public double hammerParryKnockbackStrength = 9;

    @ConfigEntry.Category("hammer")
    public int hammerSlownessAfterParry = 200;

    @ConfigEntry.Category("hammer")
    @ConfigEntry.BoundedDiscrete(max = 99, min = 1)
    public int hammerSlownessAfterParryAmplifier = 1;

    @ConfigEntry.Category("hammer")
    public int hammerWeaknessAfterParry = 0;

    @ConfigEntry.Category("hammer")
    @ConfigEntry.BoundedDiscrete(max = 99, min = 1)
    public int hammerWeaknessAfterParryAmplifier = 1;

    @ConfigEntry.Category("hammer")
    public int hammerDisarmAfterParry = 20;

    @ConfigEntry.Category("hammer")
    public int cooldownAfterInterruptingHammerBlockAction = 60;
    @ConfigEntry.Category("hammer")
    public int cooldownAfterHammerParryAction = 33;

}
