package net.fryc.hammersandtables.items.components;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {

    public static final ComponentType<BadQualityComponent> BAD_QUALITY_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(HammersAndTables.MOD_ID, "bad_quality_component"),
            ComponentType.<BadQualityComponent>builder().codec(BadQualityComponent.CODEC).build()
    );


    public static void registerModComponents(){
    }
}
