package net.fryc.hammersandtables.items;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> COPPER;
    public static final RegistryEntry<ArmorMaterial> NUGGET_COPPER;
    public static final RegistryEntry<ArmorMaterial> INGOT_COPPER;
    public static final RegistryEntry<ArmorMaterial> NUGGET_IRON;
    public static final RegistryEntry<ArmorMaterial> INGOT_IRON;
    public static final RegistryEntry<ArmorMaterial> GOLD;
    public static final RegistryEntry<ArmorMaterial> DIAMOND_GOLD;
    public static final RegistryEntry<ArmorMaterial> BONE;

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(HammersAndTables.MOD_ID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = ArmorItem.Type.values();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            ArmorItem.Type type = var9[var11];
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(HammersAndTables.MOD_ID, id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }

    static{
        COPPER = register("copper", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 3);
            map.put(ArmorItem.Type.CHESTPLATE, 4);
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.BODY, 4);
        }), 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.COPPER_INGOT});
        });

        NUGGET_COPPER = register("nugget_copper", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 3);
            map.put(ArmorItem.Type.CHESTPLATE, 4);
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.BODY, 4);
        }), 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.COPPER_INGOT});
        });

        INGOT_COPPER = register("ingot_copper", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 6);
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.BODY, 5);
        }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
        }, List.of(new ArmorMaterial.Layer(Identifier.ofVanilla("iron"), "", false)));
        NUGGET_IRON = register("nugget_iron", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 6);
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.BODY, 5);
        }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.25F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
        });
        INGOT_IRON = register("ingot_iron", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 7);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 6);
        }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
        }, List.of(new ArmorMaterial.Layer(Identifier.ofVanilla("gold"), "", false)));
        GOLD = register("gold", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 7);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 6);
        }), 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.5F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
        }, List.of(new ArmorMaterial.Layer(Identifier.ofVanilla("gold"), "", false)));
        DIAMOND_GOLD = register("diamond_gold", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 7);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 8);
        }), 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
        });
        BONE = register("bone", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 1);
            map.put(ArmorItem.Type.LEGGINGS, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 3);
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.BODY, 4);
        }), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.5F, 0.0F, () -> {
            return Ingredient.ofItems(new ItemConvertible[]{Items.BONE});
        }, List.of(new ArmorMaterial.Layer(Identifier.ofVanilla("leather"), "", true), new ArmorMaterial.Layer(Identifier.of(HammersAndTables.MOD_ID, "bone"), "", false)));
    }

    /*
    COPPER("copper", 8, new int[]{1,3,4,2}, 14 , SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    NUGGET_COPPER("nugget_copper", 10, new int[]{2,3,4,2}, 14 , SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    INGOT_COPPER("iron", 12, new int[]{2,5,6,2}, 9 , SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    NUGGET_IRON("nugget_iron", 17, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.25f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    INGOT_IRON("gold", 20, new int[]{2, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, 0.0f, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD("gold", 23, new int[]{2, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.5f, 0.0f, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    DIAMOND_GOLD("diamond_gold", 27, new int[]{2, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0f, 0.0f, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    BONE("bone", 7, new int[]{1,2,3,2}, 20 , SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.5f, 0.0f, () -> Ingredient.ofItems(Items.BONE));
     */
}
