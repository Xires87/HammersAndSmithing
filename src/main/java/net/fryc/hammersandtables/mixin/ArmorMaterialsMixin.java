package net.fryc.hammersandtables.mixin;

import net.minecraft.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ArmorMaterials.class)
abstract class ArmorMaterialsMixin {

    /* TODO zinjectowac w register zeby chainmail byl lepszy (sprawdzajac po id)

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

     */

}
