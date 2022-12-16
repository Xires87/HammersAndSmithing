package net.fryc.hammersandtables.mixin;

import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.tag.EntityTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBlock.class)
abstract class PowderSnowBlockMixin extends Block implements FluidDrainable {
    public PowderSnowBlockMixin(Settings settings) {
        super(settings);
    }

    //lets you walk on powder snow with bone boots
    @Inject(method = "canWalkOnPowderSnow(Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private static void level(Entity entity,CallbackInfoReturnable<Boolean> dur) {
        dur.setReturnValue(entity.getType().isIn(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS) ||
                (entity instanceof LivingEntity && ((LivingEntity) entity).getEquippedStack(EquipmentSlot.FEET).isIn(ModItemTags.POWDER_SNOW_WALKABLE_BOOTS)));
    }
}
