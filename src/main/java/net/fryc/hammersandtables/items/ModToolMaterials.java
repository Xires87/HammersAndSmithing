package net.fryc.hammersandtables.items;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    COPPER(2, 80, 5.0f, 1f, 15, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    NUGGET_COPPER(2, 110, 5.5f, 1.5f, 14, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    INGOT_COPPER(3, 180, 6.0f, 2.0f, 13, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    NUGGET_IRON(3, 295, 6.5f, 2.5f, 12, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    INGOT_IRON(4, 365, 7f, 3f, 11, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD(4, 447, 7.0f, 3.0f, 11, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    DIAMOND_GOLD(4, 683, 7.5f, 3.5f, 10, () -> Ingredient.ofItems(Items.GOLD_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
