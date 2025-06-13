package net.fryc.hammersandtables.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.Set;

public class ComponentHelper {

    private static final Set<RegistryEntry<EntityAttribute>> BAD_QUALITY_ATTRIBUTES = ImmutableSet.of(
            EntityAttributes.GENERIC_ARMOR,
            EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
            EntityAttributes.GENERIC_ATTACK_DAMAGE,
            EntityAttributes.GENERIC_ATTACK_SPEED,
            EntityAttributes.PLAYER_MINING_EFFICIENCY
    );

    public static boolean shouldAddBadQualityComponent(ItemStack stack){
        return stack.getComponents().contains(DataComponentTypes.ATTRIBUTE_MODIFIERS) &&
                stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers().stream().anyMatch(entry -> {
                    return BAD_QUALITY_ATTRIBUTES.contains(entry.attribute());
                });
    }
}
