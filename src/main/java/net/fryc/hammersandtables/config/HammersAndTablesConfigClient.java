package net.fryc.hammersandtables.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "hammersandtablesClient")
public class HammersAndTablesConfigClient implements ConfigData {
// todo zrobic cos z tym
    @Comment("Adds tooltips telling you which smithing table is required to craft item")
    public boolean isCraftingRequirementsTooltipsEnabled = true;
    @Comment("Adds tooltips for items that can be used to trade with piglins")
    public boolean isTooltipsForGoldenItemsEnabled = true;
}
