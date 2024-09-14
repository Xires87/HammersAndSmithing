package net.fryc.hammersandtables.mixin;

import net.fryc.hammersandtables.tag.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(ToolMaterials.class)
abstract class ToolMaterialsMixin implements ToolMaterial {


    @Inject(method = "getDurability()I", at = @At("HEAD"), cancellable = true)
    private void modifyDurability(CallbackInfoReturnable<Integer> ret) {
        ToolMaterials dys = ((ToolMaterials)(Object)this);
        if(dys.equals(ToolMaterials.GOLD)) ret.setReturnValue(26);
        else if(dys.equals(ToolMaterials.WOOD)) ret.setReturnValue(6);
        else if(dys.equals(ToolMaterials.STONE)) ret.setReturnValue(17);
    }

    @Inject(method = "getInverseTag()Lnet/minecraft/registry/tag/TagKey;", at = @At("HEAD"), cancellable = true)
    private void modifyInverseTag(CallbackInfoReturnable<TagKey<Block>> ret) {
        ToolMaterials dys = ((ToolMaterials)(Object)this);
        if(dys.equals(ToolMaterials.GOLD)) ret.setReturnValue(ModBlockTags.INCORRECT_FOR_SHINY_GOLDEN_TOOL);
        else if(dys.equals(ToolMaterials.WOOD)) ret.setReturnValue(ModBlockTags.INCORRECT_FOR_WOODEN_TOOL);
        else if(dys.equals(ToolMaterials.STONE)) ret.setReturnValue(ModBlockTags.INCORRECT_FOR_STONE_TOOL);
        else if(dys.equals(ToolMaterials.IRON)) ret.setReturnValue(ModBlockTags.INCORRECT_FOR_IRON_TOOL);
        else if(dys.equals(ToolMaterials.DIAMOND)) ret.setReturnValue(ModBlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        else if(dys.equals(ToolMaterials.NETHERITE)) ret.setReturnValue(ModBlockTags.INCORRECT_FOR_NETHERITE_TOOL);
    }

    @Inject(method = "getAttackDamage()F", at = @At("HEAD"), cancellable = true)
    private void modifyDamage(CallbackInfoReturnable<Float> ret) {
        ToolMaterials dys = ((ToolMaterials)(Object)this);
        if(dys.equals(ToolMaterials.WOOD)) ret.setReturnValue(-2.0F);
        else if(dys.equals(ToolMaterials.STONE)) ret.setReturnValue(-1.0F);
        else if(dys.equals(ToolMaterials.IRON)) ret.setReturnValue(1.0F);
    }

}
