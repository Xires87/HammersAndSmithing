package net.fryc.hammersandtables.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.blocks.custom.ModSmithingTableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block COPPER_TABLE = registerBlock("copper_table",
            new ModSmithingTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2f , 3f).sounds(BlockSoundGroup.WOOD)));

    public static final Block IRON_TABLE = registerBlock("iron_table",
            new ModSmithingTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2f , 3f).sounds(BlockSoundGroup.WOOD)));
    public static final Block GOLD_TABLE = registerBlock("gold_table",
            new ModSmithingTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2f , 3f).sounds(BlockSoundGroup.WOOD)));
    public static final Block DIAMOND_TABLE = registerBlock("diamond_table",
            new ModSmithingTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2f , 3f).sounds(BlockSoundGroup.WOOD)));

    public static final Block PIGLINS_FORGE = registerBlock("piglins_forge",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).strength(1.5f , 6f).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(HammersAndTables.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(HammersAndTables.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        HammersAndTables.LOGGER.info("Registering ModBlocks for " +HammersAndTables.MOD_ID);
    }
}
