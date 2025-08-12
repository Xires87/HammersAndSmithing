package net.fryc.hammersandtables.items.components;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class BadQualityTypes {

    public static final Map<Identifier, BadQualityType> REGISTERED_TYPES = new HashMap<>();

    @Nullable
    public static BadQualityType getType(Identifier id){
        return REGISTERED_TYPES.get(id);
    }

    @Nullable
    public static BadQualityType getType(String id){
        return REGISTERED_TYPES.get(Identifier.of(id));
    }

    public static void registerBadQualityType(
            Identifier id,
            RegistryEntry<EntityAttribute> attribute,
            Function<ItemStack, Double> value,
            EntityAttributeModifier.Operation operation,
            Predicate<ItemStack> canBeApplied
    ){
        if(REGISTERED_TYPES.containsKey(id)){
            HammersAndTables.LOGGER.error("Double registration error. Bad quality type with the following id: '" + id.toString() + "' already exists!");
        }
        else {
            REGISTERED_TYPES.put(id, new BadQualityType(id, attribute, value, operation, canBeApplied));
        }
    }
}
