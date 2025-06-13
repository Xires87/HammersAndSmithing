package net.fryc.hammersandtables.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

public interface SmithingTransformAdditionalVariables extends SmithingAdditionalVariables {

    Ingredient getSmithingTemplate();
    Ingredient getSmithingBase();
    Ingredient getSmithingAddition();
    ItemStack getSmithingResult();
}
