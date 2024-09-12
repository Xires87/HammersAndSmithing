package net.fryc.hammersandtables.util;

import net.fryc.hammersandtables.items.ModToolMaterials;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;


public class AttributesHelper {

    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, float baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, (double)(baseAttackDamage + material.getAttackDamage()), EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, (double)attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    public static AttributeModifiersComponent createAttributeModifiers(float attackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, (double)(attackDamage), EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, (double)attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    public static AttributeModifiersComponent createHammerAttributeModifiers(ToolMaterial material, float baseAttackDamage, float attackSpeed){
        if(material.equals(ToolMaterials.STONE) || material.equals(ToolMaterials.IRON) || material.equals(ToolMaterials.DIAMOND)){
            return createAttributeModifiers(material, baseAttackDamage + 1f, attackSpeed);
        }
        else {
            if(material.equals(ToolMaterials.GOLD)) return createAttributeModifiers(material, baseAttackDamage + 2f, attackSpeed + 0.2f);
            if(material.equals(ToolMaterials.NETHERITE)) return createAttributeModifiers(material, baseAttackDamage, attackSpeed + 0.1f);

            return createAttributeModifiers(material, baseAttackDamage, attackSpeed);
        }
    }

    public static AttributeModifiersComponent createAxeAttributeModifiers(ToolMaterial material, float baseAttackDamage, float attackSpeed){
        if(material.equals(ModToolMaterials.COPPER)) return createAttributeModifiers(material, baseAttackDamage + 1f, attackSpeed - 0.1f);
        if(material.equals(ModToolMaterials.NUGGET_COPPER)) return createAttributeModifiers(material, baseAttackDamage + 0.5f, attackSpeed - 0.05f);
        if(material.equals(ModToolMaterials.DIAMOND_GOLD)) return createAttributeModifiers(material, baseAttackDamage - 0.5f, attackSpeed + 0.05f);

        return createAttributeModifiers(material, baseAttackDamage, attackSpeed);


    }
}
