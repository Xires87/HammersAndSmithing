package net.fryc.hammersandtables.mixin;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fryc.hammersandtables.recipes.ModSmithingRecipes;
import net.fryc.hammersandtables.util.SmithingTransformAdditionalVariables;
import net.fryc.hammersandtables.util.TransformRecipeNumber;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.util.dynamic.Codecs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;


@Mixin(SmithingTransformRecipe.Serializer.class)
abstract class SmithingTransformRecipeSerializerMixin implements RecipeSerializer<SmithingTransformRecipe> {


    private static final MapCodec<SmithingTransformRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(Ingredient.ALLOW_EMPTY_CODEC.fieldOf("template").forGetter((recipe) -> {
            return ((SmithingTransformAdditionalVariables) recipe).getSmithingTemplate();
        }), Ingredient.ALLOW_EMPTY_CODEC.fieldOf("base").forGetter((recipe) -> {
            return ((SmithingTransformAdditionalVariables) recipe).getSmithingBase();
        }), Ingredient.ALLOW_EMPTY_CODEC.fieldOf("addition").forGetter((recipe) -> {
            return ((SmithingTransformAdditionalVariables) recipe).getSmithingAddition();
        }), ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter((recipe) -> {
            return ((SmithingTransformAdditionalVariables) recipe).getSmithingResult();
        }), Codecs.POSITIVE_INT.fieldOf("additionCount").orElse(1).forGetter((additionCount) -> {
            return ((SmithingTransformAdditionalVariables) additionCount).getAdditionCount();
        }), Codecs.POSITIVE_INT.fieldOf("tableTier").orElse(0).forGetter((tableTier) -> {
            return ((SmithingTransformAdditionalVariables) tableTier).getTableTier();
        }), Codecs.POSITIVE_INT.fieldOf("hammerTier").orElse(0).forGetter((hammerTier) -> {
            return ((SmithingTransformAdditionalVariables) hammerTier).getHammerTier();
        })).apply(instance, ModSmithingRecipes::createNewSmithingTransformRecipe);
    });

    /*
    private static final Codec<SmithingTransformRecipe> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Ingredient.ALLOW_EMPTY_CODEC.fieldOf("template").forGetter((recipe) -> {
            return ((SmithingTransformAdditionalVariables) recipe).getSmithingTemplate();
        }), Ingredient.ALLOW_EMPTY_CODEC.fieldOf("base").forGetter((recipe) -> {
            return ((SmithingTransformAdditionalVariables) recipe).getSmithingBase();
        }), Ingredient.ALLOW_EMPTY_CODEC.fieldOf("addition").forGetter((recipe) -> {
            return ((SmithingTransformAdditionalVariables) recipe).getSmithingAddition();
        }), RecipeCodecs.CRAFTING_RESULT.fieldOf("result").forGetter((recipe) -> {
            return ((SmithingTransformAdditionalVariables) recipe).getSmithingResult();
        }), Codecs.createStrictOptionalFieldCodec(Codecs.POSITIVE_INT, "additionCount", 1).forGetter((additionCount) ->{
            return ((SmithingTransformAdditionalVariables) additionCount).getAdditionCount();
        }), Codecs.createStrictOptionalFieldCodec(Codecs.POSITIVE_INT, "tableTier", 0).forGetter((tableTier) ->{
            return ((SmithingTransformAdditionalVariables) tableTier).getTableTier();
        }), Codecs.createStrictOptionalFieldCodec(Codecs.POSITIVE_INT, "hammerTier", 0).forGetter((hammerTier) ->{
            return ((SmithingTransformAdditionalVariables) hammerTier).getHammerTier();
        })).apply(instance, ModSmithingRecipes::createNewSmithingTransformRecipe);
    });
     */

    @Inject(method = "codec()Lcom/mojang/serialization/MapCodec;", at = @At("HEAD"), cancellable = true)
    private void replacingCodec(CallbackInfoReturnable<MapCodec<SmithingTransformRecipe>> ret) {
        ret.setReturnValue(CODEC);
    }


    //reading additional variables for smithing recipes from map
    @Inject(method = "read(Lnet/minecraft/network/RegistryByteBuf;)Lnet/minecraft/recipe/SmithingTransformRecipe;", at = @At("HEAD"), cancellable = true)
    private static void readingSmithingRecipesFromByteBuf(RegistryByteBuf buf, CallbackInfoReturnable<SmithingTransformRecipe> ret) {
        Ingredient ingredient = (Ingredient)Ingredient.PACKET_CODEC.decode(buf);
        Ingredient ingredient2 = (Ingredient)Ingredient.PACKET_CODEC.decode(buf);
        Ingredient ingredient3 = (Ingredient)Ingredient.PACKET_CODEC.decode(buf);
        ItemStack itemStack = (ItemStack)ItemStack.PACKET_CODEC.decode(buf);

        List<Integer> vars = ModSmithingRecipes.smithingAdditionalVariables.get(TransformRecipeNumber.number);
        TransformRecipeNumber.number++;
        int additionCount = vars.get(0);
        int tableTier = vars.get(1);
        int hammerTier = vars.get(2);
        ret.setReturnValue(ModSmithingRecipes.createNewSmithingTransformRecipe(ingredient, ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier));
    }


}
