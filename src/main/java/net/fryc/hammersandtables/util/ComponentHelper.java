package net.fryc.hammersandtables.util;

import net.fryc.hammersandtables.items.components.BadQualityType;
import net.fryc.hammersandtables.items.components.BadQualityTypes;
import net.fryc.hammersandtables.items.components.ModComponents;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ComponentHelper {

    private static ArrayList<BadQualityType> getAllPossibleBadQualityModifiers(ItemStack stack){
        return new ArrayList<>(BadQualityTypes.REGISTERED_TYPES.values().stream().filter(type -> {
            return type.canBeApplied().test(stack);
        }).toList());
    }

    public static boolean shouldAddBadQualityComponent(ItemStack stack){
        if(stack.isIn(ModItemTags.ALWAYS_GOOD_QUALITY)){
            return false;
        }

        return stack.getComponents().contains(DataComponentTypes.ATTRIBUTE_MODIFIERS) || stack.getItem() instanceof ArmorItem;
    }

    public static void applyBadQualityComponent(ItemStack stack) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if(random.nextFloat() > 0.056F){
            List<BadQualityType> selectedBadQualityTypes = getAllPossibleBadQualityModifiers(stack);

            float chance = 1.0F;
            AttributeModifiersComponent component = stack.getItem() instanceof ArmorItem armor ?
                    armor.getAttributeModifiers() :
                    stack.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
            EquipmentSlot slot = stack.getItem() instanceof ArmorItem armor ?
                    armor.getSlotType() :
                    EquipmentSlot.MAINHAND;

            while(!selectedBadQualityTypes.isEmpty() && random.nextFloat() <= chance){
                BadQualityType type = selectedBadQualityTypes.get(random.nextInt(0, selectedBadQualityTypes.size()));
                component = component.with(
                        type.attribute(),
                        new EntityAttributeModifier(type.id(), -type.value().apply(stack), type.operation()),
                        AttributeModifierSlot.forEquipmentSlot(slot)
                );

                selectedBadQualityTypes.remove(type);
                chance -= 0.29F;
            }

            stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, component);
            stack.set(ModComponents.BAD_QUALITY_COMPONENT, new AttributeModifiersComponent(stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers(), true));
        }
    }

    public static void applyBadQualityComponentFromExistingComponent(ItemStack stack) {
        if(stack.getComponents().contains(ModComponents.BAD_QUALITY_COMPONENT)){
            AttributeModifiersComponent component = stack.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);

            List<AttributeModifiersComponent.Entry> defaultModifiers = stack.getItem() instanceof ArmorItem armor ?
                    armor.getAttributeModifiers().modifiers() :
                    stack.getItem().getDefaultStack().getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT).modifiers();

            HashSet<Identifier> set = new HashSet<>();
            for(AttributeModifiersComponent.Entry entry : defaultModifiers){
                component = component.with(entry.attribute(), entry.modifier(), entry.slot());
                set.add(entry.modifier().id());
            }

            for(AttributeModifiersComponent.Entry entry : stack.get(ModComponents.BAD_QUALITY_COMPONENT).modifiers()){
                if(!set.contains(entry.modifier().id())){
                    component = component.with(entry.attribute(), entry.modifier(), entry.slot());
                }
            }

            stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, component);
            stack.set(ModComponents.BAD_QUALITY_COMPONENT, new AttributeModifiersComponent(component.modifiers(), true));
        }
    }

    public static void removeBadQualityComponent(ItemStack stack) {
        if(stack.getComponents().contains(ModComponents.BAD_QUALITY_COMPONENT)){
            AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();

            List<AttributeModifiersComponent.Entry> defaultModifiers = stack.getItem() instanceof ArmorItem armor ?
                    armor.getAttributeModifiers().modifiers() :
                    stack.getItem().getDefaultStack().getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT).modifiers();

            HashSet<Identifier> set = new HashSet<>();
            for(AttributeModifiersComponent.Entry entry : defaultModifiers){
                builder.add(entry.attribute(), entry.modifier(), entry.slot());
                set.add(entry.modifier().id());
            }

            for(AttributeModifiersComponent.Entry entry : stack.get(ModComponents.BAD_QUALITY_COMPONENT).modifiers()){
                if(!set.contains(entry.modifier().id()) && !BadQualityTypes.REGISTERED_TYPES.containsKey(entry.modifier().id())){
                    builder.add(entry.attribute(), entry.modifier(), entry.slot());
                }
            }

            stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, builder.build());
            stack.remove(ModComponents.BAD_QUALITY_COMPONENT);
        }

    }
}
