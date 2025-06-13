package net.fryc.hammersandtables.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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

    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;

    int hammerTier;
    int tableTier;
    int additionCount;

    public SmithingRepairRecipe(Ingredient base, Ingredient addition, ItemStack result, int additionCount, int tableTier, int hammerTier){
        this.base = base;
        this.addition = addition;
        this.result = result;
        this.additionCount = additionCount;
        this.tableTier = tableTier;
        this.hammerTier = hammerTier;
    }

    public SmithingRepairRecipe(Ingredient base, Ingredient addition, ItemStack result){
        this.base = base;
        this.addition = addition;
        this.result = result;
        this.additionCount = 1;
        this.tableTier = 0;
        this.hammerTier = 0;
    }

    @Override
    public boolean testTemplate(ItemStack stack) {
        return stack.isEmpty();
    }

    @Override
    public boolean testBase(ItemStack stack) {
        return this.base.test(stack);
    }

    @Override
    public boolean testAddition(ItemStack stack) {
        return this.addition.test(stack);
    }

    @Override
    public boolean matches(SmithingRecipeInput input, World world) {
        return this.base.test(input.base()) && this.addition.test(input.addition());
    }

    @Override
    public ItemStack craft(SmithingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        ItemStack itemStack = input.base().copyComponentsToNewStack(this.result.getItem(), this.result.getCount());
        itemStack.applyUnvalidatedChanges(this.result.getComponentChanges());
        //itemStack.remove(); TODO tutaj usuwac ten komponent co daje low quality
        return itemStack;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return this.result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.SMITHING_REPAIR;
    }

    @Override
    public void setHammerTier(int tier) {
        this.hammerTier = tier;
    }

    @Override
    public void setTableTier(int tier) {
        this.tableTier = tier;
    }

    @Override
    public void setAdditionCount(int count) {
        this.additionCount = count;
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

    public static class Serializer implements RecipeSerializer<SmithingRepairRecipe> {
        private static final MapCodec<SmithingRepairRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
                Ingredient.ALLOW_EMPTY_CODEC.fieldOf("base").forGetter((recipe) -> recipe.base),
                Ingredient.ALLOW_EMPTY_CODEC.fieldOf("addition").forGetter((recipe) -> recipe.addition),
                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter((recipe) -> recipe.result),
                Codecs.POSITIVE_INT.fieldOf("additionCount").orElse(1).forGetter((recipe) -> recipe.additionCount),
                Codecs.POSITIVE_INT.fieldOf("tableTier").orElse(0).forGetter((recipe) -> recipe.tableTier),
                Codecs.POSITIVE_INT.fieldOf("hammerTier").orElse(0).forGetter((recipe) -> recipe.hammerTier)
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
            Ingredient ingredient2 = (Ingredient)Ingredient.PACKET_CODEC.decode(buf);
            Ingredient ingredient3 = (Ingredient)Ingredient.PACKET_CODEC.decode(buf);
            ItemStack itemStack = (ItemStack)ItemStack.PACKET_CODEC.decode(buf);
            int additionCount = PacketCodecs.INTEGER.decode(buf);
            int tableTier = PacketCodecs.INTEGER.decode(buf);
            int hammerTier = PacketCodecs.INTEGER.decode(buf);
            return new SmithingRepairRecipe(ingredient2, ingredient3, itemStack, additionCount, tableTier, hammerTier);
        }

        private static void write(RegistryByteBuf buf, SmithingRepairRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.base);
            Ingredient.PACKET_CODEC.encode(buf, recipe.addition);
            ItemStack.PACKET_CODEC.encode(buf, recipe.result);
            PacketCodecs.INTEGER.encode(buf, recipe.additionCount);
            PacketCodecs.INTEGER.encode(buf, recipe.tableTier);
            PacketCodecs.INTEGER.encode(buf, recipe.hammerTier);
        }
    }
}
