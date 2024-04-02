package net.fryc.hammersandtables.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "hammersandtablesClient")
public class HammersAndTablesConfigClient implements ConfigData {
    @Comment("Changes name of golden tools and armor (adds Shiny to its name)")
    public boolean changeNameForVanillaGoldenItems = true;
}
