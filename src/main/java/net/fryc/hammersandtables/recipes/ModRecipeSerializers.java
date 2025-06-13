package net.fryc.hammersandtables.recipes;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeSerializers {

    public static final RecipeSerializer<SmithingRepairRecipe> SMITHING_REPAIR = register("smithing_repair", new SmithingRepairRecipe.Serializer());

    private ModRecipeSerializers(){
    }

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return (S)(Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(HammersAndTables.MOD_ID, id), serializer));
    }

    public static void registerModRecipeSerializers(){
    }
}
