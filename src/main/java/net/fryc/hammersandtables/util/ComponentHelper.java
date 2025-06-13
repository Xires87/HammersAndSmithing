package net.fryc.hammersandtables.util;

import com.google.common.collect.ImmutableSet;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.items.components.ModComponents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

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
                (stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers().stream().anyMatch(entry -> {
                    return BAD_QUALITY_ATTRIBUTES.contains(entry.attribute());
                }) || stack.getItem() instanceof ArmorItem);
    }

    public static void applyBadQualityComponent(ItemStack stack) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if(random.nextFloat() > 0.056F){
            if(stack.getItem() instanceof ArmorItem armorItem){
                stack.set(ModComponents.BAD_QUALITY_COMPONENT, armorItem.getAttributeModifiers());

                double armor = random.nextDouble(0.05 * armorItem.getProtection(), 0.22 * armorItem.getProtection());
                double toughness = armorItem.getToughness() > 0.0F ? random.nextDouble(0.03 * armorItem.getToughness(), 0.18 * armorItem.getToughness()) : 0;

                if(toughness > 0){
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, armorItem.getAttributeModifiers().with(
                            EntityAttributes.GENERIC_ARMOR,
                            new EntityAttributeModifier(Identifier.of(HammersAndTables.MOD_ID, "bad_quality_armor"), -armor, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.forEquipmentSlot(armorItem.getSlotType())
                    ).with(
                            EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            new EntityAttributeModifier(Identifier.of(HammersAndTables.MOD_ID, "bad_quality_toughness"), -toughness, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.forEquipmentSlot(armorItem.getSlotType())
                    ));
                }
                else {
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, armorItem.getAttributeModifiers().with(
                            EntityAttributes.GENERIC_ARMOR,
                            new EntityAttributeModifier(Identifier.of(HammersAndTables.MOD_ID, "bad_quality_armor"), -armor, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.forEquipmentSlot(armorItem.getSlotType())
                    ));
                }

            }
            else {
                stack.set(ModComponents.BAD_QUALITY_COMPONENT, stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS));
                double damage = (double) random.nextInt(8, 28) /100;
                double speed = (double) random.nextInt(6, 28) /100;
                double miningSpeed = (double) random.nextInt(7, 28) /100;

                stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS).with(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(Identifier.of(HammersAndTables.MOD_ID, "bad_quality_damage"), -damage, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                        AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.MAINHAND)
                ).with(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(Identifier.of(HammersAndTables.MOD_ID, "bad_quality_speed"), -speed, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                        AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.MAINHAND)
                ).with(
                        EntityAttributes.PLAYER_MINING_EFFICIENCY,
                        new EntityAttributeModifier(Identifier.of(HammersAndTables.MOD_ID, "bad_quality_mining"), -miningSpeed, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                        AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.MAINHAND)
                ));
            }
        }
    }
}
