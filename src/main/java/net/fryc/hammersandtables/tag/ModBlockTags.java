package net.fryc.hammersandtables.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockTags {
    public static final TagKey<Block> TABLES = ModBlockTags.register("tables");

    private ModBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
    }
}
