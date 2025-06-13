package net.fryc.hammersandtables.mixin;

import net.fryc.hammersandtables.recipes.SmithingTransformAdditionalVariables;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.SmithingTransformRecipe;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(SmithingTransformRecipe.class)
abstract class SmithingTransformRecipeMixin implements SmithingRecipe, SmithingTransformAdditionalVariables {

    int hammerTier = 0;
    int tableTier = 0;
    int additionCount = 1;
    int hammerDamage = 4;

    @Shadow @Final Ingredient template;
    @Shadow @Final Ingredient base;
    @Shadow @Final Ingredient addition;
    @Shadow @Final ItemStack result;


    @Override
    public void setHammerTier(int tier) {
        hammerTier = tier;
    }

    @Override
    public void setTableTier(int tier) {
        tableTier = tier;
    }

    @Override
    public void setAdditionCount(int count) {
        additionCount = count;
    }

    @Override
    public void setHammerDamage(int damage) {
        hammerDamage = damage;
    }

    @Override
    public int getHammerTier() {
        return hammerTier;
    }

    @Override
    public int getTableTier() {
        return tableTier;
    }

    @Override
    public int getAdditionCount() {
        return additionCount;
    }

    @Override
    public int getHammerDamage() {
        return hammerDamage;
    }

    @Override
    public Ingredient getSmithingTemplate() {
        return this.template;
    }

    @Override
    public Ingredient getSmithingBase() {
        return this.base;
    }

    @Override
    public Ingredient getSmithingAddition() {
        return this.addition;
    }

    @Override
    public ItemStack getSmithingResult() {
        return this.result;
    }
}
