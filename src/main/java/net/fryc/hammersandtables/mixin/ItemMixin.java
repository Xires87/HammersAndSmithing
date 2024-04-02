package net.fryc.hammersandtables.mixin;

import net.fryc.hammersandtables.HammersAndTablesClient;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
abstract class ItemMixin {

    @Shadow
    @Nullable
    private String translationKey;

    @Inject(at = @At("HEAD"), method = "getTranslationKey(Lnet/minecraft/item/ItemStack;)Ljava/lang/String;")
    private void modifyTranslationKeyForGoldenItems(ItemStack stack, CallbackInfoReturnable<String> ret) {
        if(stack.isIn(ModItemTags.VANILLA_GOLDEN_ITEMS) && HammersAndTablesClient.config.changeNameForVanillaGoldenItems){
            this.translationKey = "item.shiny." + Registries.ITEM.getId(stack.getItem()).toTranslationKey();
        }
    }
}
