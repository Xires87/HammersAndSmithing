package net.fryc.hammersandtables.mixhelpers;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fryc.hammersandtables.items.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModTradeOffers extends TradeOffers{

    public static Int2ObjectMap<Factory[]> copyToFastUtilMap(ImmutableMap<Integer, Factory[]> map) {
        return new Int2ObjectOpenHashMap(map);
    }

    //Trade offers from my mod
    public static final Map<VillagerProfession, Int2ObjectMap<Factory[]>> PROFESSION_TO_LEVELED_TRADE = (Map) Util.make(Maps.newHashMap(), (map) -> {
        map.put(VillagerProfession.TOOLSMITH, ModTradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 0),new TradeOffers.BuyForOneEmeraldFactory(Items.COPPER_INGOT, 11, 8, 2), new TradeOffers.SellItemFactory(Items.STONE_PICKAXE, 1 , 1 , 2)}, 2, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 6, 8, 8), new SellEnchantedToolFactory(ModItems.COPPER_PICKAXE, 1 , 3 , 15 , 0.2f), new SellEnchantedToolFactory(ModItems.COPPER_SHOVEL, 1 , 3 , 15 , 0.2f)}, 3, new Factory[]{new SellEnchantedToolFactory(Items.IRON_SHOVEL, 2, 3, 30, 0.2f), new SellEnchantedToolFactory(Items.IRON_PICKAXE, 3, 3, 30, 0.2f)}, 4, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT, 5, 5, 15) , new TradeOffers.BuyForOneEmeraldFactory(ModItems.GOLDEN_PICKAXE, 1, 1, 120)}, 5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_PICKAXE, 7, 3, 30, 0.2f) , new SellEnchantedToolFactory(ModItems.GOLDEN_SHOVEL, 3, 3, 30, 0.2f)})));
        map.put(VillagerProfession.ARMORER, ModTradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new TradeOffers.SellItemFactory(new ItemStack(ModItems.COPPER_LEGGINGS), 5, 1, 12, 3, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(ModItems.COPPER_BOOTS), 3, 1, 12, 1, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(ModItems.COPPER_HELMET), 4, 1, 12, 2, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(ModItems.COPPER_CHESTPLATE), 6, 1, 12, 4, 0.2f)}, 2, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 6, 8, 10), new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_CHESTPLATE), 10, 1, 12, 15, 0.2f)}, 3, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT, 5, 5, 20), new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_LEGGINGS), 8, 1, 12, 15, 0.2f)}, 4, new Factory[]{new SellEnchantedToolFactory(Items.IRON_CHESTPLATE, 13, 3, 25, 0.2f), new SellEnchantedToolFactory(Items.IRON_BOOTS, 8, 3, 20, 0.2f), new SellEnchantedToolFactory(Items.IRON_LEGGINGS, 10, 3, 20, 0.2f) , new SellEnchantedToolFactory(Items.IRON_HELMET, 9, 3, 20, 0.2f)}, 5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_HELMET, 13, 3, 30, 0.2f), new SellEnchantedToolFactory(ModItems.GOLDEN_CHESTPLATE, 17, 3, 30, 0.2f)})));
        map.put(VillagerProfession.LIBRARIAN, ModTradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.PAPER, 24, 16, 2), new TradeOffers.SellItemFactory(Blocks.BOOKSHELF, 9, 1, 12, 1)}, 2, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.BOOK, 4, 12, 10), new TradeOffers.SellItemFactory(Items.LANTERN, 1, 1, 5)}, 3, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.INK_SAC, 5, 12, 20), new TradeOffers.SellItemFactory(Items.GLASS, 1, 4, 10)}, 4, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.WRITABLE_BOOK, 2, 12, 30), new ModEnchantBookFactory(15)}, 5, new Factory[]{new TradeOffers.SellItemFactory(Items.NAME_TAG, 20, 1, 30), new EnchantBookFactory(30)})));
        map.put(VillagerProfession.WEAPONSMITH, ModTradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 24, 12, 10)}, 2, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 6, 8, 10) ,new TradeOffers.SellItemFactory(new ItemStack(ModItems.COPPER_SWORD), 2, 1, 12, 2, 0.2f)}, 3, new Factory[]{new SellEnchantedToolFactory(Items.IRON_AXE, 3, 3, 12, 0.2f), new SellEnchantedToolFactory(ModItems.IRON_HAMMER, 4, 3, 15, 0.2f), new SellEnchantedToolFactory(Items.IRON_SWORD, 3, 3, 12, 0.2f)}, 4, new Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT, 4, 8, 20), new TradeOffers.SellItemFactory(Items.SHIELD, 2, 1, 3)}, 5, new Factory[]{new SellEnchantedToolFactory(ModItems.GOLDEN_SWORD, 9, 3, 30, 0.2f), new SellEnchantedToolFactory(ModItems.GOLDEN_HAMMER, 10, 3, 30, 0.2f), new SellEnchantedToolFactory(ModItems.GOLDEN_AXE, 9, 3, 30, 0.2f)})));
    });



    //Returns weaker enchants than EnchantBookFactory
    public static class ModEnchantBookFactory
            implements Factory {
        private final int experience;

        public ModEnchantBookFactory(int experience) {
            this.experience = experience;
        }

        @Override
        public TradeOffer create(Entity entity, Random random) {
            List list = Registry.ENCHANTMENT.stream().filter(Enchantment::isAvailableForEnchantedBookOffer).collect(Collectors.toList());
            Enchantment enchantment = (Enchantment)list.get(random.nextInt(list.size()));
            //int i = MathHelper.nextInt(random, enchantment.getMinLevel(), enchantment.getMaxLevel()); <--- original
            int i = enchantment.getMaxLevel();
            if(i>2) i-=2;
            else if(i>1) i-=1;
            ItemStack itemStack = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantment, i));
            int j = 2 + random.nextInt(5 + i * 10) + 3 * i;
            if (enchantment.isTreasure()) {
                if(enchantment.getMaxLevel() == 1) j*= 3;
                else j *= 2;
            }
            if (j > 64) {
                j = 64;
            }
            return new TradeOffer(new ItemStack(Items.EMERALD, j), new ItemStack(Items.BOOK), itemStack, 12, this.experience, 0.2f);
        }

    }


}
