package net.fryc.hammersandtables.mixin;

import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.items.components.ModComponents;
import net.fryc.hammersandtables.util.ComponentHelper;
import net.minecraft.component.ComponentHolder;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
abstract class ItemStackMixin implements ComponentHolder, FabricItemStack {


    @Inject(
            method = "inventoryTick(Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;IZ)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/Item;inventoryTick(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;IZ)V",
                    shift = At.Shift.AFTER
            )
    )
    private void injected(World world, Entity entity, int slot, boolean selected, CallbackInfo info) {
        ItemStack dys = ((ItemStack)(Object)this);
        if(!world.isClient()){
            if(dys.getComponents().contains(ModComponents.BAD_QUALITY_PLACEHOLDER)){
                HammersAndTables.LOGGER.warn("USUWAM KOMPONENT WYKSZYKNIK WYKSZYKNIK");
                dys.remove(ModComponents.BAD_QUALITY_PLACEHOLDER);
                ComponentHelper.applyBadQualityComponent(dys);
            }
        }
    }
}
