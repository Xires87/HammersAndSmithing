package net.fryc.hammersandtables.mixin;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorMaterials.class)
abstract class ArmorMaterialsMixin implements ArmorMaterial {

    //sets chainmail boots armor to 2
    @Inject(method = "getProtection(Lnet/minecraft/item/ArmorItem$Type;)I", at = @At("HEAD"), cancellable = true)
    private void armor(ArmorItem.Type type, CallbackInfoReturnable<Integer> dur) {
        ArmorMaterials dys = ((ArmorMaterials)(Object)this);
        if(type == ArmorItem.Type.BOOTS && dys.equals(ArmorMaterials.CHAIN)) dur.setReturnValue(2);
    }

    //sets chainmal armors toughness to 0.75
    @Inject(method = "getToughness()F", at = @At("HEAD"), cancellable = true)
    private void toughness(CallbackInfoReturnable<Float> dur) {
        ArmorMaterials dys = ((ArmorMaterials)(Object)this);
        if(dys.equals(ArmorMaterials.CHAIN)) dur.setReturnValue(0.75F);
    }

    //sets repair ingredient of chainmail armor to chain
    @Inject(method = "getRepairIngredient()Lnet/minecraft/recipe/Ingredient;", at = @At("HEAD"), cancellable = true)
    private void repair(CallbackInfoReturnable<Ingredient> dur) {
        ArmorMaterials dys = ((ArmorMaterials)(Object)this);
        if(dys.equals(ArmorMaterials.CHAIN)) dur.setReturnValue(Ingredient.ofItems(Items.CHAIN));
    }

}
