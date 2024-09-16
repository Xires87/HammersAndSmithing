package net.fryc.hammersandtables.mixin;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MiningToolItem.class)
abstract class MiningToolItemMixin {

    @ModifyVariable(method = "createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", at = @At("HEAD"), ordinal = 0)
    private static float setMinimumAttackDamageForTools(float baseAttackDamage, ToolMaterial material) {
        if(baseAttackDamage + material.getAttackDamage() < 0){
            return -material.getAttackDamage();
        }

        return baseAttackDamage;
    }
}
