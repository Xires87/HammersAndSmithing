package net.fryc.hammersandtables.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fryc.hammersandtables.items.components.ModComponents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

public class SmithingRepairRecipe implements SmithingRecipe, SmithingAdditionalVariables {

    private final int hammerTier;
    private final int tableTier;
    private final int additionCount;
    private final int hammerDamage;
    private final Ingredient addition;

    public SmithingRepairRecipe(Ingredient addition, int hammerTier, int tableTier, int additionCount, int hammerDamage){
        this.addition = addition;
        this.hammerTier = hammerTier;
        this.tableTier = tableTier;
        this.additionCount = additionCount;
        this.hammerDamage = hammerDamage;
    }

    @Override
    public boolean testTemplate(ItemStack stack) {
        return stack.isEmpty();
    }

    @Override
    public boolean testBase(ItemStack stack) {
        return stack.getComponents().contains(ModComponents.BAD_QUALITY_COMPONENT);
    }

    @Override
    public boolean testAddition(ItemStack stack) {
        return this.addition.test(stack);
    }

    @Override
    public boolean matches(SmithingRecipeInput input, World world) {
        return this.testTemplate(input.template()) && this.addition.test(input.addition()) &&
                this.testBase(input.base()) && input.base().getItem().canRepair(input.base(), input.addition());
    }

    @Override
    public ItemStack craft(SmithingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        ItemStack itemStack = input.base().copyComponentsToNewStack(input.base().getItem(), input.base().getCount());
        itemStack.applyUnvalidatedChanges(input.base().getComponentChanges());

        itemStack.remove(ModComponents.BAD_QUALITY_COMPONENT);
        itemStack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, itemStack.getItem().getDefaultStack().get(DataComponentTypes.ATTRIBUTE_MODIFIERS));

        return itemStack;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.SMITHING_REPAIR;
    }

    @Override
    public void setHammerTier(int tier) {
    }

    @Override
    public void setTableTier(int tier) {
    }

    @Override
    public void setAdditionCount(int count) {
    }

    @Override
    public void setHammerDamage(int damage) {
    }

    public Ingredient getAddition(){
        return this.addition;
    }

    @Override
    public int getHammerTier() {
        return this.hammerTier;
    }

    @Override
    public int getTableTier() {
        return this.tableTier;
    }

    @Override
    public int getAdditionCount() {
        return this.additionCount;
    }

    @Override
    public int getHammerDamage() {
        return this.hammerDamage;
    }

    public static class Serializer implements RecipeSerializer<SmithingRepairRecipe> {
        private static final MapCodec<SmithingRepairRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
                Ingredient.ALLOW_EMPTY_CODEC.fieldOf("addition").forGetter(SmithingRepairRecipe::getAddition),
                Codecs.POSITIVE_INT.fieldOf("hammerTier").orElse(5).forGetter(SmithingRepairRecipe::getHammerTier),
                Codecs.POSITIVE_INT.fieldOf("tableTier").orElse(0).forGetter(SmithingRepairRecipe::getTableTier),
                Codecs.POSITIVE_INT.fieldOf("additionCount").orElse(1).forGetter(SmithingRepairRecipe::getAdditionCount),
                Codecs.POSITIVE_INT.fieldOf("hammerDamage").orElse(4).forGetter(SmithingRepairRecipe::getHammerDamage)
        ).apply(instance, SmithingRepairRecipe::new));
        public static final PacketCodec<RegistryByteBuf, SmithingRepairRecipe> PACKET_CODEC = PacketCodec.ofStatic(SmithingRepairRecipe.Serializer::write, SmithingRepairRecipe.Serializer::read);

        public Serializer() {
        }

        public MapCodec<SmithingRepairRecipe> codec() {
            return CODEC;
        }

        public PacketCodec<RegistryByteBuf, SmithingRepairRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        private static SmithingRepairRecipe read(RegistryByteBuf buf) {
            Ingredient ingredient = (Ingredient)Ingredient.PACKET_CODEC.decode(buf);
            int hammerTier = PacketCodecs.INTEGER.decode(buf);
            int tableTier = PacketCodecs.INTEGER.decode(buf);
            int additionCount = PacketCodecs.INTEGER.decode(buf);
            int hammerDamage = PacketCodecs.INTEGER.decode(buf);

            return new SmithingRepairRecipe(ingredient, hammerTier, tableTier, additionCount, hammerDamage);
        }

        private static void write(RegistryByteBuf buf, SmithingRepairRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.addition);
            PacketCodecs.INTEGER.encode(buf, recipe.hammerTier);
            PacketCodecs.INTEGER.encode(buf, recipe.tableTier);
            PacketCodecs.INTEGER.encode(buf, recipe.additionCount);
            PacketCodecs.INTEGER.encode(buf, recipe.hammerDamage);
        }
    }
}
