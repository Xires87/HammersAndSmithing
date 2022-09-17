package net.fryc.hammersandtables.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.blocks.custom.ModSmithingTableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block COPPER_TABLE = registerBlock("copper_table",
            new ModSmithingTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2f , 3f).sounds(BlockSoundGroup.WOOD)), ItemGroup.MISC);

    public static final Block IRON_TABLE = registerBlock("iron_table",
            new ModSmithingTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2f , 3f).sounds(BlockSoundGroup.WOOD)), ItemGroup.MISC);
    public static final Block GOLD_TABLE = registerBlock("gold_table",
            new ModSmithingTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2f , 3f).sounds(BlockSoundGroup.WOOD)), ItemGroup.MISC);
    public static final Block DIAMOND_TABLE = registerBlock("diamond_table",
            new ModSmithingTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2f , 3f).sounds(BlockSoundGroup.WOOD)), ItemGroup.MISC);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(HammersAndTables.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(HammersAndTables.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks() {
        HammersAndTables.LOGGER.info("Registering ModBlocks for " +HammersAndTables.MOD_ID);
    }
}
