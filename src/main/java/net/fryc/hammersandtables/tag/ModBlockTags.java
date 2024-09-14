package net.fryc.hammersandtables.tag;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> TABLES = ModBlockTags.register("tables");
    public static final TagKey<Block> IRON_TABLES = ModBlockTags.register("iron_tables");
    public static final TagKey<Block> GOLDEN_TABLES = ModBlockTags.register("golden_tables");
    public static final TagKey<Block> DIAMOND_TABLES = ModBlockTags.register("diamond_tables");

    public static final TagKey<Block> PIGLINS_FORGE = ModBlockTags.register("piglins_forge");

    public static final TagKey<Block> INCORRECT_FOR_WOODEN_TOOL = ModBlockTags.register("incorrect_for_wooden_tool");
    public static final TagKey<Block> INCORRECT_FOR_STONE_TOOL = ModBlockTags.register("incorrect_for_stone_tool");
    public static final TagKey<Block> INCORRECT_FOR_SHINY_GOLDEN_TOOL = ModBlockTags.register("incorrect_for_shiny_golden_tool");
    public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = ModBlockTags.register("incorrect_for_copper_tool");
    public static final TagKey<Block> INCORRECT_FOR_IRON_TOOL = ModBlockTags.register("incorrect_for_iron_tool");
    public static final TagKey<Block> INCORRECT_FOR_GOLDEN_TOOL = ModBlockTags.register("incorrect_for_golden_tool");
    public static final TagKey<Block> INCORRECT_FOR_DIAMOND_TOOL = ModBlockTags.register("incorrect_for_diamond_tool");
    public static final TagKey<Block> INCORRECT_FOR_NETHERITE_TOOL = ModBlockTags.register("incorrect_for_netherite_tool");// TODO porobic JSONY przy czym trzeba tez stare przepatrzec i przerobic (np. copper ore)

    private ModBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(HammersAndTables.MOD_ID, id));
    }
}
