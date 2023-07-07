package net.fryc.hammersandtables.recipes;

import net.fryc.hammersandtables.util.SmithingTransformAdditionalVariables;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ModSmithingRecipes {

    //map holding additional variables for smithing recipes
    public static HashMap<String, int[]> smithingAdditionalVariables = new HashMap<>();

    public static SmithingTransformRecipe createNewSmithingTransformRecipe(Identifier id, Ingredient template, Ingredient base, Ingredient addition, ItemStack result, int addition_count, int table_tier, int hammer_tier){
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(id, template, base, addition, result);
        ((SmithingTransformAdditionalVariables) recipe).setAdditionCount(addition_count);
        ((SmithingTransformAdditionalVariables) recipe).setHammerTier(hammer_tier);
        ((SmithingTransformAdditionalVariables) recipe).setTableTier(table_tier);

        smithingAdditionalVariables.put(id.toString(), new int[]{((SmithingTransformAdditionalVariables) recipe).getAdditionCount(),
                ((SmithingTransformAdditionalVariables) recipe).getTableTier(), ((SmithingTransformAdditionalVariables) recipe).getHammerTier() });

        return recipe;
    }

}
