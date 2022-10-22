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
        if(dys.equals(ToolMaterials.GOLD)) dur.setReturnValue(26);
        else if(dys.equals(ToolMaterials.WOOD)) dur.setReturnValue(6);
        else if(dys.equals(ToolMaterials.STONE)) dur.setReturnValue(17);
    }

    //changes mining levels of vanilla iron, diamond and netherite tools
    @Inject(method = "getMiningLevel()I", at = @At("HEAD"), cancellable = true)
    private void level(CallbackInfoReturnable<Integer> dur) {
        ToolMaterials dys = ((ToolMaterials)(Object)this);
        if(dys.equals(ToolMaterials.IRON)) dur.setReturnValue(3);
        else if(dys.equals(ToolMaterials.DIAMOND)) dur.setReturnValue(5);
        else if(dys.equals(ToolMaterials.NETHERITE)) dur.setReturnValue(6);
    }

    //changes attack damage of wooden, stone and iron tools
    @Inject(method = "getAttackDamage()F", at = @At("HEAD"), cancellable = true)
    private void damage(CallbackInfoReturnable<Float> dur) {
        ToolMaterials dys = ((ToolMaterials)(Object)this);
        if(dys.equals(ToolMaterials.WOOD)) dur.setReturnValue(-2.0F);
        else if(dys.equals(ToolMaterials.STONE)) dur.setReturnValue(-1.0F);
        else if(dys.equals(ToolMaterials.IRON)) dur.setReturnValue(1.0F);
    }

}
