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

    private ModBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(HammersAndTables.MOD_ID, id));
    }
}
