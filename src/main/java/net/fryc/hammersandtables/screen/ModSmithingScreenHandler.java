package net.fryc.hammersandtables.screen;


import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.items.custom.HasHammerTier;
import net.fryc.hammersandtables.recipes.SmithingAdditionalVariables;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;


public class ModSmithingScreenHandler extends ForgingScreenHandler {

    private final World world;
    @Nullable
    private RecipeEntry<SmithingRecipe> currentRecipe;
    private final List<RecipeEntry<SmithingRecipe>>  recipes;

    private int additionRemovalCount = 1;

    // 1 - copper, 2 - iron, 3 - gold, 4 - diamond
    private int tier = 1;

    public ModSmithingScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public ModSmithingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ModScreenHandlers.MOD_SMITHING_SCREEN_HANDLER, syncId, playerInventory, context);
        this.world = playerInventory.player.getWorld();
        this.recipes = this.world.getRecipeManager().listAllOfType(RecipeType.SMITHING);
    }

    protected ForgingSlotsManager getForgingSlotsManager() {
        return ForgingSlotsManager.create().input(0, 8, 48, (stack) -> {
            return this.recipes.stream().anyMatch((recipe) -> {
                return ((SmithingRecipe)recipe.value()).testTemplate(stack);
            });
        }).input(1, 26, 48, (stack) -> {
            return this.recipes.stream().anyMatch((recipe) -> {
                return ((SmithingRecipe)recipe.value()).testBase(stack);
            });
        }).input(2, 44, 48, (stack) -> {
            return this.recipes.stream().anyMatch((recipe) -> {
                return ((SmithingRecipe)recipe.value()).testAddition(stack);
            });
        }).input(3, 44, 27, (stack)->{
            return stack.isDamageable() && stack.isIn(ModItemTags.HAMMERS);
        }).output(4, 98, 48).build();
    }

    protected boolean canUse(BlockState state) {
        if(state.isOf(ModBlocks.IRON_TABLE)) this.tier = 2;
        else if(state.isOf(ModBlocks.GOLD_TABLE)) this.tier = 3;
        else if(state.isOf(ModBlocks.DIAMOND_TABLE)) this.tier = 4;
        return state.isIn(ModBlockTags.TABLES);
    }

    protected boolean canTakeOutput(PlayerEntity player, boolean present) {
        return this.currentRecipe != null && this.currentRecipe.value().matches(this.createRecipeInput(), this.world) && this.hasCorrectHammer() && this.isCorrectSmithingTable() && this.hasCorrectAdditionCount();
    }

    private SmithingRecipeInput createRecipeInput() {
        return new SmithingRecipeInput(this.input.getStack(0), this.input.getStack(1), this.input.getStack(2));
    }

    //checks if correct hammer is used
    protected boolean hasCorrectHammer(){
        if(!this.getSlot(3).hasStack()) return false;
        if(this.currentRecipe.value() instanceof SmithingAdditionalVariables recipe){
            return ((HasHammerTier) this.getHammer().getItem()).getHammerTier() >= recipe.getHammerTier();
        }
        return true;
    }

    //checks if correct smithing table is used
    protected boolean isCorrectSmithingTable(){
        if(this.tier > 3) return true;
        if(this.currentRecipe.value() instanceof SmithingAdditionalVariables recipe){
            return this.tier >= recipe.getTableTier();
        }
        return true;
    }

    protected boolean hasCorrectAdditionCount(){
        if(this.additionRemovalCount == 1) return true;
        return this.additionRemovalCount <= this.getSlot(2).getStack().getCount();
    }

    protected void onTakeOutput(PlayerEntity player, ItemStack stack) {
        stack.onCraftByPlayer(player.getWorld(), player, stack.getCount());
        this.output.unlockLastRecipe(player, this.getInputStacks());
        this.damageHammer();
        this.decrementStack(0);
        this.decrementStack(1);
        for(int i = 0; i < this.additionRemovalCount; i++) {
            this.decrementStack(2);
        }
        this.removeHammerWhenNecessary();
        this.context.run((world, pos) -> {
            world.syncWorldEvent(1044, pos, 0);
        });
    }

    private void damageHammer(){
        if(this.currentRecipe.value() instanceof SmithingAdditionalVariables av){
            this.getHammer().setDamage(this.getHammer().getDamage() + av.getHammerDamage());
            return;
        }

        this.getHammer().setDamage(this.getHammer().getDamage() + 4);
    }

    private void removeHammerWhenNecessary(){
        if(this.getHammer().getDamage() > this.getHammer().getMaxDamage()){
            this.decrementStack(3);
        }
    }

    private List<ItemStack> getInputStacks() {
        return List.of(this.input.getStack(0), this.input.getStack(1), this.input.getStack(2));
    }

    private void decrementStack(int slot) {
        ItemStack itemStack = this.input.getStack(slot);
        if (!itemStack.isEmpty()) {
            itemStack.decrement(1);
            this.input.setStack(slot, itemStack);
        }

    }

    public void updateResult() {
        SmithingRecipeInput smithingRecipeInput = this.createRecipeInput();
        List<RecipeEntry<SmithingRecipe>> list = this.world.getRecipeManager().getAllMatches(RecipeType.SMITHING, smithingRecipeInput, this.world);
        if (list.isEmpty()) {
            this.output.setStack(0, ItemStack.EMPTY);
        } else {
            RecipeEntry<SmithingRecipe> recipeEntry = (RecipeEntry)list.get(0);
            ItemStack itemStack = ((SmithingRecipe)recipeEntry.value()).craft(smithingRecipeInput, this.world.getRegistryManager());
            if (itemStack.isItemEnabled(this.world.getEnabledFeatures())) {
                this.currentRecipe = recipeEntry;
                if(this.currentRecipe.value() instanceof SmithingAdditionalVariables stav){
                    this.additionRemovalCount = stav.getAdditionCount();
                    if(this.additionRemovalCount < 1) this.additionRemovalCount = 1;
                }
                else this.additionRemovalCount = 1;
                this.output.setLastRecipe(recipeEntry);
                if(this.currentRecipe.value() instanceof SmithingAdditionalVariables stav){
                    if(stav.getTableTier() <= this.tier) this.output.setStack(0, itemStack);
                    else this.output.setStack(0, ItemStack.EMPTY);
                }
                else{
                    this.output.setStack(0, itemStack);
                }
            }
        }

    }

    public int getSlotFor(ItemStack stack) {
        return (Integer)((Optional)this.recipes.stream().map((recipe) -> {
            return getQuickMoveSlot(recipe.value(), stack);
        }).filter(Optional::isPresent).findFirst().orElse(Optional.of(0))).get();
    }



    private static Optional<Integer> getQuickMoveSlot(SmithingRecipe recipe, ItemStack stack) {
        if (recipe.testTemplate(stack)) {
            return Optional.of(0);
        } else if (recipe.testBase(stack)) {
            return Optional.of(1);
        } else if(recipe.testAddition(stack)) {
            return Optional.of(2);
        } else if(stack.isIn(ModItemTags.HAMMERS)){
            return Optional.of(3);
        } else {
            return Optional.empty();
        }
    }

    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.output && super.canInsertIntoSlot(stack, slot);
    }

    public boolean isValidIngredient(ItemStack stack) {
        return this.recipes.stream().map((recipe) -> {
            return getQuickMoveSlot(recipe.value(), stack);
        }).anyMatch(Optional::isPresent);
    }

    private ItemStack getHammer(){
        return this.getSlot(3).getStack();
    }

}
