package net.fryc.hammersandtables.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fryc.hammersandtables.items.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetDamageLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTables {
    private static final Identifier TRIAL_RARE
            = Identifier.ofVanilla("chests/trial_chambers/reward_rare");

    private static final Identifier OMINOUS_TRIAL_RARE
            = Identifier.ofVanilla("chests/trial_chambers/reward_ominous_rare");

    private static final Identifier SIMPLE_DUNGEON
            = Identifier.ofVanilla("chests/simple_dungeon");

    private static final Identifier ANCIENT_CITY
            = Identifier.ofVanilla("chests/ancient_city");

    private static final Identifier STRONGHOLD
            = Identifier.ofVanilla("chests/stronghold_crossing");

    private static final Identifier TRAIL_RUINS
            = Identifier.ofVanilla("archaeology/trail_ruins_rare");

    public static void modifyLoot(){
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(TRIAL_RARE.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.26f))
                        .with(ItemEntry.builder(ModItems.MASTER_TOOLS))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.5F, 0.8F)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)));
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(OMINOUS_TRIAL_RARE.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33f))
                        .with(ItemEntry.builder(ModItems.MASTER_TOOLS))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F, 1.0F)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)));
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(SIMPLE_DUNGEON.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.18f))
                        .with(ItemEntry.builder(ModItems.MASTER_TOOLS))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.3F, 0.6F)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)));
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(ANCIENT_CITY.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.14f))
                        .with(ItemEntry.builder(ModItems.MASTER_TOOLS))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)));
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(STRONGHOLD.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.28f))
                        .with(ItemEntry.builder(ModItems.MASTER_TOOLS))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)));
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(TRAIL_RUINS.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.08f))
                        .with(ItemEntry.builder(ModItems.MASTER_TOOLS))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.3F, 0.6F)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)));
                tableBuilder.pool(poolBuilder.build());
            }
        });



    }
}
