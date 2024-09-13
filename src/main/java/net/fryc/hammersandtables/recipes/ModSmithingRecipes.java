package net.fryc.hammersandtables.recipes;

import net.fryc.hammersandtables.util.SmithingTransformAdditionalVariables;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingTransformRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModSmithingRecipes {

    //map holding additional variables for smithing recipes
    public static HashMap<Integer, List<Integer>> smithingAdditionalVariables = new HashMap<>();
    private static int number = 0;

    public static SmithingTransformRecipe createNewSmithingTransformRecipe(Ingredient template, Ingredient base, Ingredient addition, ItemStack result, int addition_count, int table_tier, int hammer_tier){
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(template, base, addition, result);
        ((SmithingTransformAdditionalVariables) recipe).setAdditionCount(addition_count);
        ((SmithingTransformAdditionalVariables) recipe).setHammerTier(hammer_tier);
        ((SmithingTransformAdditionalVariables) recipe).setTableTier(table_tier);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(((SmithingTransformAdditionalVariables) recipe).getAdditionCount());
        list.add(((SmithingTransformAdditionalVariables) recipe).getTableTier());
        list.add(((SmithingTransformAdditionalVariables) recipe).getHammerTier());

        smithingAdditionalVariables.put(number, list);
        number++;

        return recipe;
    }

}
