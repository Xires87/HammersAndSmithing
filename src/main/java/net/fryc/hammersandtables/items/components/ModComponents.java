package net.fryc.hammersandtables.items.components;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.UnaryOperator;

public class ModComponents {

    public static final Identifier BAD_QUALITY_ARMOR_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_armor");
    public static final Identifier BAD_QUALITY_TOUGHNESS_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_toughness");
    public static final Identifier BAD_QUALITY_MOVEMENT_SPEED_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_movement_speed");
    public static final Identifier BAD_QUALITY_SNEAKING_SPEED_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_sneaking_speed");

    public static final Identifier BAD_QUALITY_DAMAGE_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_damage");
    public static final Identifier BAD_QUALITY_ATTACK_SPEED_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_attack_speed");
    public static final Identifier BAD_QUALITY_ENTITY_INTERACTION_RANGE_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_entity_interaction_range");
    public static final Identifier BAD_QUALITY_ATTACK_KNOCKBACK_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_attack_knockback");

    public static final Identifier BAD_QUALITY_BLOCK_INTERACTION_RANGE_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_block_interaction_range");
    public static final Identifier BAD_QUALITY_BLOCK_BREAK_SPEED_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_block_break_speed");
    public static final Identifier BAD_QUALITY_MINING_EFFICIENCY_ID = Identifier.of(HammersAndTables.MOD_ID, "bad_quality_mining_efficiency");


    public static final ComponentType<Boolean> BAD_QUALITY_PLACEHOLDER = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(HammersAndTables.MOD_ID, "bad_quality_placeholder"),
            ComponentType.<Boolean>builder().codec(Codec.BOOL).build()
    );

    public static final ComponentType<AttributeModifiersComponent> BAD_QUALITY_COMPONENT = register(
            "bad_quality",
            (builder) -> {
                return builder.codec(AttributeModifiersComponent.CODEC).packetCodec(AttributeModifiersComponent.PACKET_CODEC).cache();
            }
    );


    public static void registerModComponents(){
        //armor --------------------------------------------------------------------------------------------------------
        BadQualityTypes.registerBadQualityType(BAD_QUALITY_ARMOR_ID, EntityAttributes.GENERIC_ARMOR, stack -> {
            return stack.getItem() instanceof ArmorItem armor ?
                    ThreadLocalRandom.current().nextDouble(0.05 * armor.getProtection(), 0.22 * armor.getProtection()) :
                    0.0;
        }, EntityAttributeModifier.Operation.ADD_VALUE, stack -> {
            return stack.getItem() instanceof ArmorItem armor && armor.getProtection() > 0;
        });

        BadQualityTypes.registerBadQualityType(BAD_QUALITY_TOUGHNESS_ID, EntityAttributes.GENERIC_ARMOR_TOUGHNESS, stack -> {
            return stack.getItem() instanceof ArmorItem armor ?
                    ThreadLocalRandom.current().nextDouble(0.08 * armor.getToughness(), 0.22 * armor.getToughness()) :
                    0.0;
        }, EntityAttributeModifier.Operation.ADD_VALUE, stack -> {
            return stack.getItem() instanceof ArmorItem armor && armor.getToughness() > 0;
        });

        BadQualityTypes.registerBadQualityType(BAD_QUALITY_MOVEMENT_SPEED_ID, EntityAttributes.GENERIC_MOVEMENT_SPEED, stack -> {
            return ThreadLocalRandom.current().nextDouble(0.01, 0.05);
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.getItem() instanceof ArmorItem;
        });

        BadQualityTypes.registerBadQualityType(BAD_QUALITY_SNEAKING_SPEED_ID, EntityAttributes.PLAYER_SNEAKING_SPEED, stack -> {
            return ThreadLocalRandom.current().nextDouble(0.04, 0.09);
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.getItem() instanceof ArmorItem;
        });


        //weapon -------------------------------------------------------------------------------------------------------
        BadQualityTypes.registerBadQualityType(BAD_QUALITY_DAMAGE_ID, EntityAttributes.GENERIC_ATTACK_DAMAGE, stack -> {
            return (double) ThreadLocalRandom.current().nextInt(5, 25) /100;
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.isIn(ItemTags.SWORDS) || stack.isIn(ModItemTags.HAMMERS) || stack.isIn(ItemTags.AXES) || stack.isIn(ConventionalItemTags.MELEE_WEAPON_TOOLS);
        });

        BadQualityTypes.registerBadQualityType(BAD_QUALITY_ATTACK_SPEED_ID, EntityAttributes.GENERIC_ATTACK_SPEED, stack -> {
            return (double) ThreadLocalRandom.current().nextInt(5, 25) /100;
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.isIn(ItemTags.SWORDS) || stack.isIn(ModItemTags.HAMMERS) || stack.isIn(ItemTags.AXES) || stack.isIn(ConventionalItemTags.MELEE_WEAPON_TOOLS);
        });

        BadQualityTypes.registerBadQualityType(BAD_QUALITY_ENTITY_INTERACTION_RANGE_ID, EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, stack -> {
            return (double) ThreadLocalRandom.current().nextInt(5, 25) /100;
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.isIn(ItemTags.SWORDS) || stack.isIn(ModItemTags.HAMMERS) || stack.isIn(ItemTags.AXES) || stack.isIn(ConventionalItemTags.MELEE_WEAPON_TOOLS);
        });

        BadQualityTypes.registerBadQualityType(BAD_QUALITY_ATTACK_KNOCKBACK_ID, EntityAttributes.GENERIC_ATTACK_KNOCKBACK, stack -> {
            return (double) ThreadLocalRandom.current().nextInt(5, 25) /100;
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.isIn(ItemTags.SWORDS) || stack.isIn(ModItemTags.HAMMERS) || stack.isIn(ItemTags.AXES) || stack.isIn(ConventionalItemTags.MELEE_WEAPON_TOOLS);
        });


        //tool ---------------------------------------------------------------------------------------------------------
        BadQualityTypes.registerBadQualityType(BAD_QUALITY_BLOCK_INTERACTION_RANGE_ID, EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, stack -> {
            return (double) ThreadLocalRandom.current().nextInt(5, 25) /100;
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.isIn(ItemTags.PICKAXES) || stack.isIn(ItemTags.SHOVELS) ||
                    stack.isIn(ItemTags.HOES) || stack.isIn(ItemTags.AXES) || stack.isIn(ConventionalItemTags.MINING_TOOL_TOOLS);
        });

        BadQualityTypes.registerBadQualityType(BAD_QUALITY_MINING_EFFICIENCY_ID, EntityAttributes.PLAYER_MINING_EFFICIENCY, stack -> {
            return (double) ThreadLocalRandom.current().nextInt(5, 25) /100;
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.isIn(ItemTags.PICKAXES) || stack.isIn(ItemTags.SHOVELS) ||
                    stack.isIn(ItemTags.HOES) || stack.isIn(ItemTags.AXES) || stack.isIn(ConventionalItemTags.MINING_TOOL_TOOLS);
        });

        BadQualityTypes.registerBadQualityType(BAD_QUALITY_BLOCK_BREAK_SPEED_ID, EntityAttributes.PLAYER_BLOCK_BREAK_SPEED, stack -> {
            return (double) ThreadLocalRandom.current().nextInt(5, 25) /100;
        }, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE, stack -> {
            return stack.isIn(ItemTags.PICKAXES) || stack.isIn(ItemTags.SHOVELS) ||
                    stack.isIn(ItemTags.HOES) || stack.isIn(ItemTags.AXES) || stack.isIn(ConventionalItemTags.MINING_TOOL_TOOLS);
        });
    }

    private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return (ComponentType)Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(HammersAndTables.MOD_ID, id), ((ComponentType.Builder)builderOperator.apply(ComponentType.builder())).build());
    }
}
