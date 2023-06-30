package net.fryc.hammersandtables.screen;


import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.items.custom.HammerItem;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.fryc.hammersandtables.util.SmithingTransformAdditionalVariables;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;


public class ModSmithingScreenHandler extends ForgingScreenHandler {

    public static final int field_41924 = 0;
    public static final int field_41925 = 1;
    public static final int field_41926 = 2;
    public static final int field_41927 = 4;
    public static final int field_41928 = 8;
    public static final int field_41929 = 26;
    public static final int field_41930 = 44;
    private static final int field_41932 = 98;
    public static final int field_41931 = 48;
    private final World world;
    @Nullable
    private SmithingRecipe currentRecipe;
    private final List<SmithingRecipe> recipes;

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
                return recipe.testTemplate(stack);
            });
        }).input(1, 26, 48, (stack) -> {
            return this.recipes.stream().anyMatch((smithingRecipe) -> {
                return smithingRecipe.testBase(stack);
            });
        }).input(2, 44, 48, (stack) -> {
            return this.recipes.stream().anyMatch((smithingRecipe) -> {
                return smithingRecipe.testAddition(stack);
            });
        }).input(3, 44, 27, (stack)->{
            return stack.isIn(ModItemTags.HAMMERS);
        }).output(4, 98, 48).build();
    }

    protected boolean canUse(BlockState state) {
        if(state.isOf(ModBlocks.IRON_TABLE)) this.tier = 2;
        else if(state.isOf(ModBlocks.GOLD_TABLE)) this.tier = 3;
        else if(state.isOf(ModBlocks.DIAMOND_TABLE)) this.tier = 4;
        return state.isIn(ModBlockTags.TABLES);
    }

    protected boolean canTakeOutput(PlayerEntity player, boolean present) {
        return this.currentRecipe != null && this.currentRecipe.matches(this.input, this.world) && this.hasCorrectHammer() && this.isCorrectSmithingTable() && this.hasCorrectAdditionCount();
    }

    //checks if correct hammer is used
    protected boolean hasCorrectHammer(){
        if(!this.getSlot(3).hasStack()) return false;
        if(this.currentRecipe instanceof SmithingTransformAdditionalVariables recipe){
            return ((HammerItem) this.getHammer().getItem()).tier >= recipe.getHammerTier();
        }
        return true;
    }

    //checks if correct smithing table is used
    protected boolean isCorrectSmithingTable(){
        if(this.tier > 3) return true;
        if(this.currentRecipe instanceof SmithingTransformAdditionalVariables recipe){
            return this.tier >= recipe.getTableTier();
        }
        return true;
    }

    protected boolean hasCorrectAdditionCount(){
        if(this.additionRemovalCount == 1) return true;
        return this.additionRemovalCount <= this.getSlot(2).getStack().getCount();
    }

    protected void onTakeOutput(PlayerEntity player, ItemStack stack) {
        stack.onCraft(player.getWorld(), player, stack.getCount());
        this.output.unlockLastRecipe(player, this.getInputStacks());
        this.decrementStack(0);
        this.decrementStack(1);
        for(int i = 0; i < this.additionRemovalCount; i++) {
            this.decrementStack(2);
        }
        this.getHammer().setDamage(this.getHammer().getDamage() + 4);
        if(this.getHammer().getDamage() > this.getHammer().getMaxDamage()) this.decrementStack(3);
        this.context.run((world, pos) -> {
            world.syncWorldEvent(1044, pos, 0);
        });
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
        List<SmithingRecipe> list = this.world.getRecipeManager().getAllMatches(RecipeType.SMITHING, this.input, this.world);
        if (list.isEmpty()) {
            this.output.setStack(0, ItemStack.EMPTY);
        } else {
            SmithingRecipe smithingRecipe = (SmithingRecipe)list.get(0);
            ItemStack itemStack = smithingRecipe.craft(this.input, this.world.getRegistryManager());
            if (itemStack.isItemEnabled(this.world.getEnabledFeatures())) {
                this.currentRecipe = smithingRecipe;
                if(this.currentRecipe instanceof SmithingTransformAdditionalVariables stav){
                    this.additionRemovalCount = stav.getAdditionCount();
                    if(this.additionRemovalCount < 1) this.additionRemovalCount = 1;
                }
                else this.additionRemovalCount = 1;
                this.output.setLastRecipe(smithingRecipe);
                if(this.currentRecipe instanceof SmithingTransformAdditionalVariables stav){
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
            return getQuickMoveSlot(recipe, stack);
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
            return getQuickMoveSlot(recipe, stack);
        }).anyMatch(Optional::isPresent);
    }

    private ItemStack getHammer(){
        return this.getSlot(3).getStack();
    }

}
