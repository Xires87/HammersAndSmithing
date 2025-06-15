package net.fryc.hammersandtables.util;

import com.google.common.collect.ImmutableSet;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.items.components.ModComponents;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class ComponentHelper {

    private static final Identifier BAD_QUALITY_ARMOR_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_armor");
    private static final Identifier BAD_QUALITY_TOUGHNESS_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_toughness");
    private static final Identifier BAD_QUALITY_DAMAGE_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_damage");
    private static final Identifier BAD_QUALITY_SPEED_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_speed");
    private static final Identifier BAD_QUALITY_MINING_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_mining");

    private static final Set<RegistryEntry<EntityAttribute>> BAD_QUALITY_ATTRIBUTES = ImmutableSet.of(
            EntityAttributes.GENERIC_ATTACK_DAMAGE,
            EntityAttributes.GENERIC_ATTACK_SPEED,
            EntityAttributes.PLAYER_MINING_EFFICIENCY
    );

    private static final Set<Identifier> BAD_QUALITY_IDENTIFIERS = ImmutableSet.of(
            BAD_QUALITY_ARMOR_ID,
            BAD_QUALITY_TOUGHNESS_ID,
            BAD_QUALITY_DAMAGE_ID,
            BAD_QUALITY_SPEED_ID,
            BAD_QUALITY_MINING_ID
    );

    public static boolean shouldAddBadQualityComponent(ItemStack stack){
        if(stack.isIn(ModItemTags.ALWAYS_GOOD_QUALITY)){
            return false;
        }

        return stack.getComponents().contains(DataComponentTypes.ATTRIBUTE_MODIFIERS) &&
                (stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers().stream().anyMatch(entry -> {
                    return BAD_QUALITY_ATTRIBUTES.contains(entry.attribute());
                }) || stack.getItem() instanceof ArmorItem);
    }

    public static void applyBadQualityComponent(ItemStack stack) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if(random.nextFloat() > 0.056F){
            if(stack.getItem() instanceof ArmorItem armorItem){

                double armor = random.nextDouble(0.05 * armorItem.getProtection(), 0.22 * armorItem.getProtection());
                double toughness = armorItem.getToughness() > 0.0F ? random.nextDouble(0.08 * armorItem.getToughness(), 0.22 * armorItem.getToughness()) : 0;

                if(toughness > 0){
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, armorItem.getAttributeModifiers().with(
                            EntityAttributes.GENERIC_ARMOR,
                            new EntityAttributeModifier(BAD_QUALITY_ARMOR_ID, -armor, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.forEquipmentSlot(armorItem.getSlotType())
                    ).with(
                            EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            new EntityAttributeModifier(BAD_QUALITY_TOUGHNESS_ID, -toughness, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.forEquipmentSlot(armorItem.getSlotType())
                    ));
                }
                else {
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, armorItem.getAttributeModifiers().with(
                            EntityAttributes.GENERIC_ARMOR,
                            new EntityAttributeModifier(BAD_QUALITY_ARMOR_ID, -armor, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.forEquipmentSlot(armorItem.getSlotType())
                    ));
                }

                stack.set(ModComponents.BAD_QUALITY_COMPONENT, new AttributeModifiersComponent(stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers(), true));
            }
            else {
                double damage = (double) random.nextInt(8, 28) /100;
                double speed = (double) random.nextInt(6, 28) /100;
                double miningSpeed = (double) random.nextInt(7, 28) /100;


                stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS).with(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(BAD_QUALITY_DAMAGE_ID, -damage, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                        AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.MAINHAND)
                ).with(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BAD_QUALITY_SPEED_ID, -speed, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                        AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.MAINHAND)
                ).with(
                        EntityAttributes.PLAYER_MINING_EFFICIENCY,
                        new EntityAttributeModifier(BAD_QUALITY_MINING_ID, -miningSpeed, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                        AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.MAINHAND)
                ));

                stack.set(ModComponents.BAD_QUALITY_COMPONENT, new AttributeModifiersComponent(stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS).modifiers(), true));
            }
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
                if(!set.contains(entry.modifier().id()) && !BAD_QUALITY_IDENTIFIERS.contains(entry.modifier().id())){
                    builder.add(entry.attribute(), entry.modifier(), entry.slot());
                }
            }

            stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, builder.build());
            stack.remove(ModComponents.BAD_QUALITY_COMPONENT);
        }

    }
}
