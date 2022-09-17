package net.fryc.hammersandtables.mixin;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(ToolMaterials.class)
abstract class ToolMaterialsMixin implements ToolMaterial {

    //changes durability of vanilla wooden, golden and stone tools
    @Inject(method = "getDurability()I", at = @At("HEAD"), cancellable = true)
    private void durability(CallbackInfoReturnable<Integer> dur) {
        ToolMaterials dys = ((ToolMaterials)(Object)this);
        if(dys.getEnchantability() == 22) dur.setReturnValue(26);
        else if(dys.getMiningSpeedMultiplier() == 2.0F) dur.setReturnValue(6);
        else if(dys.getMiningLevel() == 1) dur.setReturnValue(17);
    }

    //changes mining levels of vanilla iron, diamond and netherite tools
    @Inject(method = "getMiningLevel()I", at = @At("HEAD"), cancellable = true)
    private void level(CallbackInfoReturnable<Integer> dur) {
        ToolMaterials dys = ((ToolMaterials)(Object)this);
        if(dys.getEnchantability() == 14) dur.setReturnValue(3);
        else if(dys.getEnchantability() == 10) dur.setReturnValue(5);
        else if(dys.getMiningSpeedMultiplier() == 9.0F) dur.setReturnValue(6);
    }

    //changes attack damage of wooden, stone and iron tools
    @Inject(method = "getAttackDamage()F", at = @At("HEAD"), cancellable = true)
    private void damage(CallbackInfoReturnable<Float> dur) {
        ToolMaterials dys = ((ToolMaterials)(Object)this);
        if(dys.getMiningSpeedMultiplier() == 2.0F) dur.setReturnValue(-2.0F);
        else if(dys.getMiningSpeedMultiplier() == 4.0F) dur.setReturnValue(-1.0F);
        else if(dys.getMiningSpeedMultiplier() == 6.0F) dur.setReturnValue(1.0F);
    }

}
