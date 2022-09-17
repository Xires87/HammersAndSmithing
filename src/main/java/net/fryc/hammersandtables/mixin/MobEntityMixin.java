package net.fryc.hammersandtables.mixin;

import net.fryc.hammersandtables.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
abstract class MobEntityMixin extends LivingEntity {

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    //mobs spawn with bone armor instead of golden armor
    @Inject(at = @At("HEAD"), method = "getEquipmentForSlot(Lnet/minecraft/entity/EquipmentSlot;I)Lnet/minecraft/item/Item;", cancellable = true)
    private static void setArmor(EquipmentSlot equipmentSlot , int equipmentLevel, CallbackInfoReturnable<Item> ret) {
        if(equipmentLevel == 1){
            if(equipmentSlot == EquipmentSlot.HEAD) ret.setReturnValue(ModItems.BONE_HELMET);
            else if(equipmentSlot == EquipmentSlot.CHEST) ret.setReturnValue(ModItems.BONE_CHESTPLATE);
            else if(equipmentSlot == EquipmentSlot.LEGS) ret.setReturnValue(ModItems.BONE_LEGGINGS);
            else if(equipmentSlot == EquipmentSlot.FEET) ret.setReturnValue(ModItems.BONE_BOOTS);
        }
    }

}
