package net.fryc.hammersandtables.mixin;


import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fryc.hammersandtables.recipes.ModSmithingRecipes;
import net.fryc.hammersandtables.util.SmithingTransformAdditionalVariables;
import net.fryc.hammersandtables.util.TransformRecipeNumber;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeCodecs;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.util.dynamic.Codecs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(SmithingTransformRecipe.Serializer.class)
abstract class SmithingTransformRecipeSerializerMixin implements RecipeSerializer<SmithingTransformRecipe> {


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

    @Inject(method = "codec()Lcom/mojang/serialization/Codec;", at = @At("HEAD"), cancellable = true)
    private void replacingCodec(CallbackInfoReturnable<Codec<SmithingTransformRecipe>> ret) {
        ret.setReturnValue(CODEC);
    }


    /* old
    @Inject(method = "read(Lnet/minecraft/util/Identifier;Lcom/google/gson/JsonObject;)Lnet/minecraft/recipe/SmithingTransformRecipe;", at = @At("HEAD"), cancellable = true)
    private void readingSmithingRecipesFromJson(Identifier identifier, JsonObject jsonObject, CallbackInfoReturnable<SmithingTransformRecipe> ret) {
        Ingredient ingredient = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "template"));
        Ingredient ingredient2 = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "base"));
        Ingredient ingredient3 = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "addition"));
        ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "result"));
        int additionCount = JsonHelper.getInt(jsonObject, "additionCount", 1);
        int tableTier = JsonHelper.getInt(jsonObject, "tableTier", 0);
        int hammerTier = JsonHelper.getInt(jsonObject, "hammerTier", tableTier);
        ret.setReturnValue(ModSmithingRecipes.createNewSmithingTransformRecipe(ingredient, ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier));
    }
    */


    //reading additional variables for smithing recipes from map
    @Inject(method = "read(Lnet/minecraft/network/PacketByteBuf;)Lnet/minecraft/recipe/SmithingTransformRecipe;", at = @At("HEAD"), cancellable = true)
    private void readingSmithingRecipesFromPacketByteBuf(PacketByteBuf packetByteBuf, CallbackInfoReturnable<SmithingTransformRecipe> ret) {
        Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
        Ingredient ingredient2 = Ingredient.fromPacket(packetByteBuf);
        Ingredient ingredient3 = Ingredient.fromPacket(packetByteBuf);
        ItemStack itemStack = packetByteBuf.readItemStack();
        int[] vars = ModSmithingRecipes.smithingAdditionalVariables.get(TransformRecipeNumber.number);
        TransformRecipeNumber.number++;
        int additionCount = vars[0];
        int tableTier = vars[1];
        int hammerTier = vars[2];
        ret.setReturnValue(ModSmithingRecipes.createNewSmithingTransformRecipe(ingredient, ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier));
    }


}
