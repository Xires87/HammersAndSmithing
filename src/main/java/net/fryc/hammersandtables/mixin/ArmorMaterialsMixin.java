package net.fryc.hammersandtables.mixin;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

@Mixin(ArmorMaterials.class)
abstract class ArmorMaterialsMixin {

    @ModifyVariable(method = "register(Ljava/lang/String;Ljava/util/EnumMap;ILnet/minecraft/registry/entry/RegistryEntry;FFLjava/util/function/Supplier;Ljava/util/List;)Lnet/minecraft/registry/entry/RegistryEntry;", at = @At("HEAD"), ordinal = 0)
    private static float modifyChainmailToughness(float toughness, String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughnessv2, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        if(id.equals("chainmail")){
            return toughness + 0.75f;
        }
        return toughness;
    }

    @ModifyVariable(method = "register(Ljava/lang/String;Ljava/util/EnumMap;ILnet/minecraft/registry/entry/RegistryEntry;FFLjava/util/function/Supplier;Ljava/util/List;)Lnet/minecraft/registry/entry/RegistryEntry;", at = @At("HEAD"), ordinal = 0)
    private static EnumMap<ArmorItem.Type, Integer> modifyChainmailBootsArmor(EnumMap<ArmorItem.Type, Integer> defense, String id, EnumMap<ArmorItem.Type, Integer> defensev2, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        if(id.equals("chainmail")){
            defense.put(ArmorItem.Type.BOOTS, defense.get(ArmorItem.Type.BOOTS)+1);
        }
        return defense;
    }

    @ModifyVariable(method = "register(Ljava/lang/String;Ljava/util/EnumMap;ILnet/minecraft/registry/entry/RegistryEntry;FFLjava/util/function/Supplier;Ljava/util/List;)Lnet/minecraft/registry/entry/RegistryEntry;", at = @At("HEAD"), ordinal = 0)
    private static Supplier<Ingredient> modifyChainmailRepairIngredient(Supplier<Ingredient> repairIngredient, String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientv2, List<ArmorMaterial.Layer> layers) {
        if(id.equals("chainmail")){
            repairIngredient = () -> {
                return Ingredient.ofItems(new ItemConvertible[]{Items.CHAIN});
            };
            return repairIngredient;
        }
        return repairIngredient;
    }

}
