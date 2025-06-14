package net.fryc.hammersandtables.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.fryc.hammersandtables.items.components.ModComponents;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.fryc.hammersandtables.util.ComponentHelper;
import net.fryc.hammersandtables.util.interfaces.TicksInventory;
import net.minecraft.component.ComponentHolder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ItemStack.class)
abstract class ItemStackMixin implements ComponentHolder, FabricItemStack {

    private int tickDelay = 0;

// TODO dodac receptury do naprawiania innych itemow
    // TODO dodac master toole do loot tabli
    // TODO dodac receptury na crafting kity
    @Inject(
            method = "inventoryTick(Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;IZ)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/Item;inventoryTick(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;IZ)V",
                    shift = At.Shift.AFTER
            )
    )
    private void onInventoryTick(World world, Entity entity, int slot, boolean selected, CallbackInfo info) {
        ItemStack dys = ((ItemStack)(Object)this);
        if(!world.isClient()){
            if(dys.getComponents().contains(ModComponents.BAD_QUALITY_PLACEHOLDER)){
                dys.remove(ModComponents.BAD_QUALITY_PLACEHOLDER);
                ComponentHelper.applyBadQualityComponent(dys);
            }

            // it's definitely better to check integer instead of giving status effect 20 times per second
            if(dys.isIn(ModItemTags.SLOWS_DOWN_WHEN_IN_INVENTORY)){
                if(entity instanceof LivingEntity living){
                    if(((TicksInventory) living).getTickDelay() < 1){
                        living.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 80, 2));
                        ((TicksInventory) living).setTickDelay(60);
                    }
                    else {
                        ((TicksInventory) living).decrementTickDelay();
                    }
                }
            }
        }
    }



    @WrapWithCondition(
            method = "getTooltip(Lnet/minecraft/item/Item$TooltipContext;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/tooltip/TooltipType;)Ljava/util/List;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item;appendTooltip(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/Item$TooltipContext;Ljava/util/List;Lnet/minecraft/item/tooltip/TooltipType;)V")
    )
    private boolean addTooltips(Item instance, ItemStack dys, Item.TooltipContext context, List<Text> list, TooltipType type) {
        if(dys.getComponents().contains(ModComponents.BAD_QUALITY_PLACEHOLDER)){
            list.add(Text.translatable("text.hammersandtables.tooltip.bad_quality_item").formatted(Formatting.RED));
        }
        if(dys.isIn(ModItemTags.SLOWS_DOWN_WHEN_IN_INVENTORY)){
            list.add(Text.translatable("text.hammersandtables.tooltip.heavy_item").formatted(Formatting.RED));
        }

        return true;
    }
}
