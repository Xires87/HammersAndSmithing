package net.fryc.hammersandtables.items;

import com.google.common.base.Suppliers;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.Objects;
import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    COPPER(ModBlockTags.INCORRECT_FOR_COPPER_TOOL, 80, 5.0f, 1f, 15, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    NUGGET_COPPER(ModBlockTags.INCORRECT_FOR_COPPER_TOOL, 110, 5.5f, 1.5f, 14, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    INGOT_COPPER(ModBlockTags.INCORRECT_FOR_IRON_TOOL, 180, 6.0f, 2.0f, 13, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    NUGGET_IRON(ModBlockTags.INCORRECT_FOR_IRON_TOOL, 295, 6.5f, 2.5f, 12, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    INGOT_IRON(ModBlockTags.INCORRECT_FOR_GOLDEN_TOOL, 365, 7f, 3f, 11, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    GOLD(ModBlockTags.INCORRECT_FOR_GOLDEN_TOOL, 447, 7.0f, 3.0f, 11, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    DIAMOND_GOLD(ModBlockTags.INCORRECT_FOR_GOLDEN_TOOL, 683, 7.5f, 3.5f, 10, () -> Ingredient.ofItems(Items.GOLD_INGOT));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
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
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
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
