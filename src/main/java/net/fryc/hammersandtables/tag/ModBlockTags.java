package net.fryc.hammersandtables.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockTags {
    public static final TagKey<Block> TABLES = ModBlockTags.register("tables");
    public static final TagKey<Block> IRON_TABLES = ModBlockTags.register("iron_tables");
    public static final TagKey<Block> GOLDEN_TABLES = ModBlockTags.register("golden_tables");
    public static final TagKey<Block> DIAMOND_TABLES = ModBlockTags.register("diamond_tables");

    private ModBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
    }
}
