package net.fryc.hammersandtables.mixin;


import net.fryc.hammersandtables.recipes.ModSmithingRecipes;
import net.fryc.hammersandtables.util.SmithingTransformAdditionalVariables;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import com.google.gson.JsonObject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(SmithingTransformRecipe.Serializer.class)
abstract class SmithingTransformRecipeSerializerMixin {

    // todo zrobic wszystkie jsony

    @Inject(method = "read(Lnet/minecraft/util/Identifier;Lcom/google/gson/JsonObject;)Lnet/minecraft/recipe/SmithingTransformRecipe;", at = @At("HEAD"), cancellable = true)
    private void readingJson(Identifier identifier, JsonObject jsonObject, CallbackInfoReturnable<SmithingTransformRecipe> ret) {
        Ingredient ingredient = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "template"));
        Ingredient ingredient2 = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "base"));
        Ingredient ingredient3 = Ingredient.fromJson(JsonHelper.getElement(jsonObject, "addition"));
        ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "result"));
        int additionCount = JsonHelper.getInt(jsonObject, "additionCount", 1);
        int tableTier = JsonHelper.getInt(jsonObject, "tableTier", 0);
        int hammerTier = JsonHelper.getInt(jsonObject, "HammerTier", tableTier);
        ret.setReturnValue(ModSmithingRecipes.createNewSmithingTransformRecipe(identifier, ingredient, ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier));
    }

    @Inject(method = "read(Lnet/minecraft/util/Identifier;Lnet/minecraft/network/PacketByteBuf;)Lnet/minecraft/recipe/SmithingTransformRecipe;", at = @At("HEAD"), cancellable = true)
    private void readingJsonWithPacketByteBuf(Identifier identifier, PacketByteBuf packetByteBuf, CallbackInfoReturnable<SmithingTransformRecipe> ret) {
        Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
        Ingredient ingredient2 = Ingredient.fromPacket(packetByteBuf);
        Ingredient ingredient3 = Ingredient.fromPacket(packetByteBuf);
        ItemStack itemStack = packetByteBuf.readItemStack();
        int additionCount = packetByteBuf.getInt(0);
        int tableTier = packetByteBuf.getInt(1);
        int hammerTier = packetByteBuf.getInt(2);
        ret.setReturnValue(ModSmithingRecipes.createNewSmithingTransformRecipe(identifier, ingredient, ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier));
    }

    @Inject(method = "write(Lnet/minecraft/network/PacketByteBuf;Lnet/minecraft/recipe/SmithingTransformRecipe;)V", at = @At("HEAD"), cancellable = true)
    private void writingToPacketByteBuf(PacketByteBuf packetByteBuf, SmithingTransformRecipe smithingTransformRecipe, CallbackInfo info) {
        ((SmithingTransformAdditionalVariables) smithingTransformRecipe).getSmithingTemplate().write(packetByteBuf);
        ((SmithingTransformAdditionalVariables) smithingTransformRecipe).getSmithingBase().write(packetByteBuf);
        ((SmithingTransformAdditionalVariables) smithingTransformRecipe).getSmithingAddition().write(packetByteBuf);
        packetByteBuf.writeItemStack(((SmithingTransformAdditionalVariables) smithingTransformRecipe).getSmithingResult());
        packetByteBuf.writeInt(((SmithingTransformAdditionalVariables) smithingTransformRecipe).getAdditionCount());
        packetByteBuf.writeInt(((SmithingTransformAdditionalVariables) smithingTransformRecipe).getTableTier());
        packetByteBuf.writeInt(((SmithingTransformAdditionalVariables) smithingTransformRecipe).getHammerTier());
        info.cancel();
    }



}
