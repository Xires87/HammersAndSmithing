package net.fryc.hammersandtables.util;

import net.fryc.hammersandtables.recipes.SmithingTransformAdditionalVariables;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingTransformRecipe;

public class TransformRecipeHelper {

    public static SmithingTransformRecipe createNewSmithingTransformRecipe(Ingredient template, Ingredient base, Ingredient addition, ItemStack result, int addition_count, int table_tier, int hammer_tier, int hammer_damage){
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(template, base, addition, result);
        ((SmithingTransformAdditionalVariables) recipe).setAdditionCount(addition_count);
        ((SmithingTransformAdditionalVariables) recipe).setHammerTier(hammer_tier);
        ((SmithingTransformAdditionalVariables) recipe).setTableTier(table_tier);
        ((SmithingTransformAdditionalVariables) recipe).setHammerDamage(hammer_damage);

        return recipe;
    }

}
