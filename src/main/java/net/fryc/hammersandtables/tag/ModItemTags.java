package net.fryc.hammersandtables.tag;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModItemTags {
    public static final TagKey<Item> HAMMERS = ModItemTags.register("hammers");
    public static final TagKey<Item> IRON_HAMMERS = ModItemTags.register("iron_hammers");
    public static final TagKey<Item> GOLDEN_HAMMERS = ModItemTags.register("golden_hammers");
    public static final TagKey<Item> DIAMOND_HAMMERS = ModItemTags.register("diamond_hammers");
    public static final TagKey<Item> COPPER_BLOCKS = ModItemTags.register("copper_blocks");
    public static final TagKey<Item> VANILLA_GOLDEN_ITEMS = ModItemTags.register("vanilla_golden_items");
    public static final TagKey<Item> TABLES_INGREDIENTS = ModItemTags.register("tables_ingredients");
    public static final TagKey<Item> NEEDS_COPPER_SMITHING_TABLE = ModItemTags.register("needs_copper_smithing_table");
    public static final TagKey<Item> NEEDS_IRON_SMITHING_TABLE = ModItemTags.register("needs_iron_smithing_table");
    public static final TagKey<Item> NEEDS_GOLDEN_SMITHING_TABLE = ModItemTags.register("needs_golden_smithing_table");
    public static final TagKey<Item> NEEDS_DIAMOND_SMITHING_TABLE = ModItemTags.register("needs_diamond_smithing_table");

    public static final TagKey<Item> POWDER_SNOW_WALKABLE_BOOTS = ModItemTags.register("powder_snow_walkable_boots");



    private ModItemTags() {
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(HammersAndTables.MOD_ID, id));
    }
}
