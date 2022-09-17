package net.fryc.hammersandtables.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WitherSkeletonEntity.class)
abstract class WitherSkeletonMixin extends AbstractSkeletonEntity {

    protected WitherSkeletonMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    //wither skeletons spawn with iron swords
    @Redirect(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/WitherSkeletonEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V"))
    private void ironSword(WitherSkeletonEntity witherskeletonentity, EquipmentSlot slot, ItemStack stack) {
        slot = EquipmentSlot.MAINHAND;
        stack = new ItemStack(Items.IRON_SWORD);
        witherskeletonentity.equipStack(slot, stack);
    }

}
