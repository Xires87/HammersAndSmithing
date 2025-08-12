package net.fryc.hammersandtables.items.components;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.function.Predicate;

public record BadQualityType(
        Identifier id,
        RegistryEntry<EntityAttribute> attribute,
        Function<ItemStack, Double> value,
        EntityAttributeModifier.Operation operation,
        Predicate<ItemStack> canBeApplied
) {

}
