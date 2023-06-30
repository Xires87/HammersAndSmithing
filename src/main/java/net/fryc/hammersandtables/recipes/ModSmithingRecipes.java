package net.fryc.hammersandtables.recipes;

import net.fryc.hammersandtables.util.SmithingTransformAdditionalVariables;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.util.Identifier;

public class ModSmithingRecipes {


    public static SmithingTransformRecipe createNewSmithingTransformRecipe(Identifier id, Ingredient template, Ingredient base, Ingredient addition, ItemStack result, int addition_count, int table_tier, int hammer_tier){
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(id, template, base, addition, result);
        ((SmithingTransformAdditionalVariables) recipe).setAdditionCount(addition_count);
        ((SmithingTransformAdditionalVariables) recipe).setHammerTier(hammer_tier);
        ((SmithingTransformAdditionalVariables) recipe).setTableTier(table_tier);
        return recipe;
    }

}
