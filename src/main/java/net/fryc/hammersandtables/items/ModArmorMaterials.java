package net.fryc.hammersandtables.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    COPPER("copper", 8, new int[]{1,3,4,2}, 14 , SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    NUGGET_COPPER("nugget_copper", 10, new int[]{2,3,4,2}, 14 , SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    INGOT_COPPER("iron", 12, new int[]{2,5,6,2}, 9 , SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    NUGGET_IRON("nugget_iron", 17, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.25f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    INGOT_IRON("gold", 20, new int[]{2, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, 0.0f, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD("gold", 23, new int[]{2, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.5f, 0.0f, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    DIAMOND_GOLD("diamond_gold", 27, new int[]{2, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0f, 0.0f, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    BONE("bone", 7, new int[]{1,2,3,2}, 20 , SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.5f, 0.0f, () -> Ingredient.ofItems(Items.BONE));


    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }

}
