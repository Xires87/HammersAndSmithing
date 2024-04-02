package net.fryc.hammersandtables.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkeletonEntity.class)
abstract class WitherSkeletonMixin extends AbstractSkeletonEntity {

    protected WitherSkeletonMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    //old
    /*
    @Redirect(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/WitherSkeletonEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V"))
    private void ironSword(WitherSkeletonEntity witherskeletonentity, EquipmentSlot slot, ItemStack stack) {
        slot = EquipmentSlot.MAINHAND;
        stack = new ItemStack(Items.IRON_SWORD);
        witherskeletonentity.equipStack(slot, stack);
    }

     */

    @Inject(method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At("TAIL"))
    private void equipIronSword(Random random, LocalDifficulty localDifficulty, CallbackInfo info) {
        ((WitherSkeletonEntity)(Object)this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
    }



}
