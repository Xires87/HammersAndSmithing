package net.fryc.hammersandtables.villagers;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.items.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.util.Util;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.Map;

public class ModTradeOffers extends TradeOffers{

    public static Int2ObjectMap<Factory[]> copyToFastUtilMap(ImmutableMap<Integer, Factory[]> map) {
        return new Int2ObjectOpenHashMap(map);
    }

    public static void registerModTradeOffers(){
        if(HammersAndTables.config.modifyTradeOffersForArmorer) TradeOffers.PROFESSION_TO_LEVELED_TRADE.replace(VillagerProfession.ARMORER, TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.ARMORER), ModTradeOffers.MOD_PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.ARMORER));
        if(HammersAndTables.config.modifyTradeOffersForToolsmith) TradeOffers.PROFESSION_TO_LEVELED_TRADE.replace(VillagerProfession.TOOLSMITH, TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.TOOLSMITH), ModTradeOffers.MOD_PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.TOOLSMITH));
        if(HammersAndTables.config.modifyTradeOffersForWeaponsmith) TradeOffers.PROFESSION_TO_LEVELED_TRADE.replace(VillagerProfession.WEAPONSMITH, TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.WEAPONSMITH), ModTradeOffers.MOD_PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.WEAPONSMITH));
        if(HammersAndTables.config.modifyTradeOffersForLibrarian) TradeOffers.PROFESSION_TO_LEVELED_TRADE.replace(VillagerProfession.LIBRARIAN, TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LIBRARIAN), ModTradeOffers.MOD_PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.LIBRARIAN));
    }

    //Trade offers from my mod (toolsmith, armorer and weaponsmith changed)
    public static final Map<VillagerProfession, Int2ObjectMap<Factory[]>> MOD_PROFESSION_TO_LEVELED_TRADE = (Map) Util.make(Maps.newHashMap(), (map) -> {

        map.put(VillagerProfession.LIBRARIAN, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyItemFactory(Items.PAPER, 24, 16, 2), new SellItemFactory(Blocks.BOOKSHELF, 9, 1, 12, 1)},
                2, new Factory[]{new BuyItemFactory(Items.BOOK, 4, 12, 10), new EnchantBookFactory(5, EnchantmentTags.TRADEABLE), new SellItemFactory(Items.LANTERN, 1, 1, 5)},
                3, new Factory[]{new BuyItemFactory(Items.INK_SAC, 5, 12, 20), new EnchantBookFactory(10, EnchantmentTags.TRADEABLE), new SellItemFactory(Items.GLASS, 1, 4, 10)},
                4, new Factory[]{new BuyItemFactory(Items.WRITABLE_BOOK, 2, 12, 30), new EnchantBookFactory(15, EnchantmentTags.TRADEABLE), new SellItemFactory(Items.CLOCK, 5, 1, 15), new SellItemFactory(Items.COMPASS, 4, 1, 15)},
                5, new Factory[]{new SellItemFactory(Items.NAME_TAG, 20, 1, 30), new EnchantBookFactory(30, EnchantmentTags.TRADEABLE)})));

        map.put(VillagerProfession.TOOLSMITH, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyItemFactory(Items.COPPER_INGOT, 12, 16, 2), new SellItemFactory(new ItemStack(ModItems.COPPER_SHOVEL), 1, 1, 4, 1, 0.2F), new SellItemFactory(new ItemStack(ModItems.COPPER_HOE), 1, 1, 4, 1, 0.2F)},
                2, new Factory[]{new BuyItemFactory(Items.IRON_INGOT, 4, 12, 10), new SellEnchantedToolFactory(ModItems.COPPER_PICKAXE, 2, 3, 10, 0.2F) },
                3, new Factory[]{new BuyItemFactory(Items.FLINT, 30, 12, 20), new SellEnchantedToolFactory(ModItems.GOLDEN_HOE, 2, 3, 10, 0.2F), new SellEnchantedToolFactory(Items.IRON_SHOVEL, 2, 3, 10, 0.2F)},
                4, new Factory[]{new BuyItemFactory(Items.GOLD_INGOT, 3, 12, 10), new SellEnchantedToolFactory(Items.IRON_PICKAXE, 6, 3, 15, 0.2F), new SellEnchantedToolFactory(ModItems.GOLDEN_SHOVEL, 3, 3, 15, 0.2F)},
                5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_PICKAXE, 9, 3, 30, 0.2F), new SellItemFactory(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2F), new SellItemFactory(new ItemStack(ModItems.MASTER_TOOLS), 32, 1, 1, 30, 0.2F)})));

        map.put(VillagerProfession.ARMORER, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyItemFactory(Items.COAL, 15, 16, 2), new SellItemFactory(new ItemStack(ModItems.COPPER_LEGGINGS), 5, 1, 12, 1, 0.2F), new SellItemFactory(new ItemStack(ModItems.COPPER_BOOTS), 1, 1, 12, 1, 0.2F), new SellItemFactory(new ItemStack(ModItems.COPPER_HELMET), 2, 1, 12, 1, 0.2F), new SellItemFactory(new ItemStack(ModItems.COPPER_CHESTPLATE), 6, 1, 12, 1, 0.2F)},
                2, new Factory[]{new BuyItemFactory(Items.IRON_INGOT, 4, 12, 10), new SellItemFactory(new ItemStack(Items.CHAINMAIL_BOOTS), 5, 1, 12, 5, 0.2F), new SellItemFactory(new ItemStack(Items.CHAINMAIL_LEGGINGS), 8, 1, 12, 5, 0.2F), new SellItemFactory(new ItemStack(Items.SHIELD), 5, 1, 12, 10, 0.2F)},
                3, new Factory[]{new BuyItemFactory(Items.LAVA_BUCKET, 1, 12, 20), new SellItemFactory(new ItemStack(Items.CHAINMAIL_HELMET), 6, 1, 12, 10, 0.2F), new SellItemFactory(new ItemStack(Items.CHAINMAIL_CHESTPLATE), 10, 1, 12, 10, 0.2F)},
                4, new Factory[]{new BuyItemFactory(Items.GOLD_INGOT, 3, 12, 10), new ProcessItemFactory(Items.IRON_CHESTPLATE, 1, 2, ModItems.INGOT_IRON_CHESTPLATE, 1, 1 ,15, 0.2F)},
                5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_HELMET, 6, 3, 30, 0.2F), new SellEnchantedToolFactory(ModItems.GOLDEN_CHESTPLATE, 12, 3, 30, 0.2F), new SellEnchantedToolFactory(ModItems.GOLDEN_LEGGINGS, 10, 3, 30, 0.2F) , new SellEnchantedToolFactory(ModItems.GOLDEN_BOOTS, 4, 3, 30, 0.2F), new SellItemFactory(new ItemStack(ModItems.MASTER_TOOLS), 32, 1, 1, 30, 0.2F)})));

        map.put(VillagerProfession.WEAPONSMITH, copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new BuyItemFactory(Items.COAL, 15, 16, 2), new SellItemFactory(new ItemStack(ModItems.COPPER_AXE), 2, 1, 12, 1, 0.2F), new SellItemFactory(new ItemStack(ModItems.COPPER_SWORD), 1, 1, 12, 1, 0.2F)},
                2, new Factory[]{new BuyItemFactory(Items.IRON_INGOT, 4, 12, 10), new BuyItemFactory(Items.FLINT, 24, 12, 20)},
                3, new Factory[]{new SellEnchantedToolFactory(Items.IRON_AXE, 4, 3, 15), new SellEnchantedToolFactory(Items.IRON_SWORD, 4, 3, 15)},
                4, new Factory[]{new BuyItemFactory(Items.DIAMOND, 1, 12, 30), new ProcessItemFactory(Items.IRON_SWORD, 1, 2, ModItems.INGOT_IRON_SWORD, 1, 1 ,15, 0.2F)},
                5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_SWORD, 6, 3, 30, 0.2F), new SellEnchantedToolFactory(ModItems.GOLDEN_AXE, 6, 3, 30, 0.2F), new SellItemFactory(new ItemStack(ModItems.MASTER_TOOLS), 32, 1, 1, 30, 0.2F)})));

    });


}
