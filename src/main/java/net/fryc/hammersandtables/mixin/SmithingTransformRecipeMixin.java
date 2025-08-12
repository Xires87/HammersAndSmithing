package net.fryc.hammersandtables.mixin;

import net.fryc.hammersandtables.recipes.SmithingTransformAdditionalVariables;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Mixin(SmithingTransformRecipe.class)
abstract class SmithingTransformRecipeMixin implements SmithingRecipe, SmithingTransformAdditionalVariables {

    int hammerTier = 0;
    int tableTier = 0;
    int additionCount = 1;
    int hammerDamage = 4;

    @Shadow @Final Ingredient template;
    @Shadow @Final Ingredient base;
    @Shadow @Final Ingredient addition;
    @Shadow @Final ItemStack result;

    @Inject(at = @At("HEAD"), method = "craft(Lnet/minecraft/recipe/input/SmithingRecipeInput;Lnet/minecraft/registry/RegistryWrapper$WrapperLookup;)Lnet/minecraft/item/ItemStack;", cancellable = true)
    private void handleBadQualityComponent(SmithingRecipeInput smithingRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup, CallbackInfoReturnable<ItemStack> ret) {
        List<AttributeModifiersComponent.Entry> defaultModifiers = this.result.getItem() instanceof ArmorItem armor ?
                armor.getAttributeModifiers().modifiers() :
                this.result.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT).modifiers();

        ItemStack itemStack = smithingRecipeInput.base().copyComponentsToNewStack(this.result.getItem(), this.result.getCount());
        itemStack.applyUnvalidatedChanges(this.result.getComponentChanges());

        ArrayList<AttributeModifiersComponent.Entry> allModifiers = new ArrayList<>(defaultModifiers);
        Set<Identifier> defaultIdentifiers = new HashSet<>();
        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();

        defaultModifiers.forEach(entry -> defaultIdentifiers.add(entry.modifier().id()));
        allModifiers.addAll(itemStack.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT).modifiers().stream().filter(entry -> !defaultIdentifiers.contains(entry.modifier().id())).toList());
        allModifiers.forEach(entry -> builder.add(entry.attribute(), entry.modifier(), entry.slot()));

        itemStack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, builder.build());
        ret.setReturnValue(itemStack);
    }


    @Override
    public void setHammerTier(int tier) {
        hammerTier = tier;
    }

    @Override
    public void setTableTier(int tier) {
        tableTier = tier;
    }

    @Override
    public void setAdditionCount(int count) {
        additionCount = count;
    }

    @Override
    public void setHammerDamage(int damage) {
        hammerDamage = damage;
    }

    @Override
    public int getHammerTier() {
        return hammerTier;
    }

    @Override
    public int getTableTier() {
        return tableTier;
    }

    @Override
    public int getAdditionCount() {
        return additionCount;
    }

    @Override
    public int getHammerDamage() {
        return hammerDamage;
    }

    @Override
    public Ingredient getSmithingTemplate() {
        return this.template;
    }

    @Override
    public Ingredient getSmithingBase() {
        return this.base;
    }

    @Override
    public Ingredient getSmithingAddition() {
        return this.addition;
    }

    @Override
    public ItemStack getSmithingResult() {
        return this.result;
    }
}
