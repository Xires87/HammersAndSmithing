package net.fryc.hammersandtables.mixin;



import net.fryc.hammersandtables.recipes.ModSmithingRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import com.google.gson.JsonObject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(SmithingTransformRecipe.Serializer.class)
abstract class SmithingTransformRecipeSerializerMixin implements RecipeSerializer<SmithingTransformRecipe> {


    //reading recipe from Json
    @Inject(method = "read(Lnet/minecraft/util/Identifier;Lcom/google/gson/JsonObject;)Lnet/minecraft/recipe/SmithingTransformRecipe;", at = @At("HEAD"), cancellable = true)
    private void readingSmithingRecipesFromJson(Identifier identifier, JsonObject jsonObject, CallbackInfoReturnable<SmithingTransformRecipe> ret) {
        Ingredient ingredient = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "template"));
        Ingredient ingredient2 = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "base"));
        Ingredient ingredient3 = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "addition"));
        ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "result"));
        int additionCount = JsonHelper.getInt(jsonObject, "additionCount", 1);
        int tableTier = JsonHelper.getInt(jsonObject, "tableTier", 0);
        int hammerTier = JsonHelper.getInt(jsonObject, "hammerTier", tableTier);
        ret.setReturnValue(ModSmithingRecipes.createNewSmithingTransformRecipe(identifier, ingredient, ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier));
    }


    //reading additional variables for smithing recipes from map
    @Inject(method = "read(Lnet/minecraft/util/Identifier;Lnet/minecraft/network/PacketByteBuf;)Lnet/minecraft/recipe/SmithingTransformRecipe;", at = @At("HEAD"), cancellable = true)
    private void readingSmithingRecipesFromPacketByteBuf(Identifier identifier, PacketByteBuf packetByteBuf, CallbackInfoReturnable<SmithingTransformRecipe> ret) {
        Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
        Ingredient ingredient2 = Ingredient.fromPacket(packetByteBuf);
        Ingredient ingredient3 = Ingredient.fromPacket(packetByteBuf);
        ItemStack itemStack = packetByteBuf.readItemStack();
        int[] vars = ModSmithingRecipes.smithingAdditionalVariables.get(identifier.toString());
        int additionCount = vars[0];
        int tableTier = vars[1];
        int hammerTier = vars[2];
        ret.setReturnValue(ModSmithingRecipes.createNewSmithingTransformRecipe(identifier, ingredient, ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier));
    }


}
