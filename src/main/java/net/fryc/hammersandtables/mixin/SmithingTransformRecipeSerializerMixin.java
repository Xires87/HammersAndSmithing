package net.fryc.hammersandtables.mixin;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fryc.hammersandtables.recipes.SmithingTransformAdditionalVariables;
import net.fryc.hammersandtables.util.TransformRecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.util.dynamic.Codecs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


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
        }), Codecs.POSITIVE_INT.fieldOf("hammerDamage").orElse(4).forGetter((hammerTier) -> {
            return ((SmithingTransformAdditionalVariables) hammerTier).getHammerTier();
        })).apply(instance, TransformRecipeHelper::createNewSmithingTransformRecipe);
    });


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

        int additionCount = PacketCodecs.INTEGER.decode(buf);
        int tableTier = PacketCodecs.INTEGER.decode(buf);
        int hammerTier = PacketCodecs.INTEGER.decode(buf);
        int hammerDamage = PacketCodecs.INTEGER.decode(buf);

        ret.setReturnValue(TransformRecipeHelper.createNewSmithingTransformRecipe(ingredient, ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier, hammerDamage));
    }

    @Inject(method = "write(Lnet/minecraft/network/RegistryByteBuf;Lnet/minecraft/recipe/SmithingTransformRecipe;)V", at = @At("TAIL"), cancellable = true)
    private static void readingSmithingRecipesFromByteBuf(RegistryByteBuf buf, SmithingTransformRecipe recipe, CallbackInfo info) {
        SmithingTransformAdditionalVariables stav = ((SmithingTransformAdditionalVariables) recipe);
        PacketCodecs.INTEGER.encode(buf, stav.getAdditionCount());
        PacketCodecs.INTEGER.encode(buf, stav.getTableTier());
        PacketCodecs.INTEGER.encode(buf, stav.getHammerTier());
        PacketCodecs.INTEGER.encode(buf, stav.getHammerDamage());
    }
}
