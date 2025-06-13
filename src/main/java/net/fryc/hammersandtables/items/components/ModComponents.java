package net.fryc.hammersandtables.items.components;

import com.mojang.serialization.Codec;
import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModComponents {



    public static final ComponentType<Boolean> BAD_QUALITY_PLACEHOLDER = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(HammersAndTables.MOD_ID, "bad_quality_placeholder"),
            ComponentType.<Boolean>builder().codec(Codec.BOOL).build()
    );

    public static final ComponentType<AttributeModifiersComponent> BAD_QUALITY_COMPONENT = register(
            "attribute_modifiers",
            (builder) -> {
                return builder.codec(AttributeModifiersComponent.CODEC).packetCodec(AttributeModifiersComponent.PACKET_CODEC).cache();
            }
    );


    public static void registerModComponents(){
    }

    private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return (ComponentType)Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(HammersAndTables.MOD_ID, id), ((ComponentType.Builder)builderOperator.apply(ComponentType.builder())).build());
    }
}
