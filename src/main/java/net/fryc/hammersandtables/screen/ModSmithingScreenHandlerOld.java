package net.fryc.hammersandtables.screen;

import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.screen.screenNew.ModScreenHandlers;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModSmithingScreenHandlerOld extends ModForgingScreenHandlerOld {

    private boolean copper = false;
    private boolean iron = false;
    private boolean gold = false;
    private boolean diamond = false;
    private final World world;
    @Nullable
    private SmithingRecipe currentRecipe;
    private final List<SmithingRecipe> recipes;

    public ModSmithingScreenHandlerOld(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public ModSmithingScreenHandlerOld(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ModScreenHandlers.MOD_SMITHING_SCREEN_HANDLER, syncId, playerInventory, context);
        this.world = playerInventory.player.getWorld();
        this.recipes = this.world.getRecipeManager().listAllOfType(RecipeType.SMITHING);
    }

    protected boolean canUse(BlockState state) {
        if(state.isOf(ModBlocks.COPPER_TABLE)){
            copper = true; iron = false; gold = false; diamond = false;
            return true;
        }
        else if(state.isOf(ModBlocks.IRON_TABLE)){
            copper = false; iron = true; gold = false; diamond = false;
            return true;
        }
        else if(state.isOf(ModBlocks.GOLD_TABLE)){
            copper = false; iron = false; gold = true; diamond = false;
            return true;
        }
        else if(state.isOf(ModBlocks.DIAMOND_TABLE)){
            copper = false; iron = false; gold = false; diamond = true;
            return true;
        }
        else return false;
    }

    protected boolean canTakeOutput(PlayerEntity player, boolean present) {
        return this.currentRecipe != null && this.currentRecipe.matches(this.input, this.world);
    }

    protected void onTakeOutput(PlayerEntity player, ItemStack stack) {
        stack.onCraft(player.getWorld(), player, stack.getCount());
        //this.output.unlockLastRecipe(player);
        this.decrementStack(0);
        if(this.input.getStack(1).isOf(Items.IRON_NUGGET) || this.input.getStack(1).isOf(Items.GOLD_NUGGET)){
            this.decrementStack(1);this.decrementStack(1);this.decrementStack(1);
        }
        else{
            this.decrementStack(1);
        }
        this.input.getStack(3).setDamage(this.input.getStack(3).getDamage() + 4);
        if(this.input.getStack(3).getDamage() < 0) this.decrementStack(3);
        this.context.run((world, pos) -> {
            world.syncWorldEvent(1044, pos, 0);
        });
    }

    private void decrementStack(int slot) {
        ItemStack itemStack = this.input.getStack(slot);
        itemStack.decrement(1);
        this.input.setStack(slot, itemStack);
    }
    //returns item from hammer slot
    protected ItemStack getHammer(){
        return this.input.getStack(3);
    }

    //shows item in output slot
    protected void showItem(List<SmithingRecipe> list){
        this.currentRecipe = (SmithingRecipe)list.get(0);
        ItemStack itemStack = this.currentRecipe.craft(this.input, this.world.getRegistryManager());
        this.output.setLastRecipe(this.currentRecipe);
        this.output.setStack(0, itemStack);
    }

    //smithing with copper hammers
    protected void copperCraft(List<SmithingRecipe> list){
        if((this.input.getStack(1).isOf(Items.IRON_NUGGET) && this.input.getStack(1).getCount() >=3) ||
                (this.input.getStack(1).isOf(Items.IRON_INGOT) && getHammer().isIn(ModItemTags.IRON_HAMMERS))){
            showItem(list);
        }
    }

    //smithing with iron hammers
    protected void ironCraft(List<SmithingRecipe> list){
        if((this.input.getStack(1).isOf(Items.GOLD_NUGGET) && this.input.getStack(1).getCount() >=3) ||
                this.input.getStack(1).isOf(Items.IRON_INGOT) ||
                (this.input.getStack(1).isOf(Items.IRON_NUGGET) && this.input.getStack(1).getCount() >=3) ||
                (getHammer().isIn(ModItemTags.GOLDEN_HAMMERS) && this.input.getStack(1).isOf(Items.GOLD_INGOT))){
            showItem(list);
        }
    }

    //smithing with golden hammers
    protected void goldCraft(List<SmithingRecipe> list){
        if((this.input.getStack(1).isOf(Items.GOLD_NUGGET) && this.input.getStack(1).getCount() >=3) ||
                this.input.getStack(1).isOf(Items.IRON_INGOT) ||
                (this.input.getStack(1).isOf(Items.IRON_NUGGET) && this.input.getStack(1).getCount() >=3) ||
                this.input.getStack(1).isOf(Items.GOLD_INGOT) || this.input.getStack(1).isOf(Items.DIAMOND)){
            showItem(list);
        }
    }
    public void updateResult() {
        List<SmithingRecipe> list = this.world.getRecipeManager().getAllMatches(RecipeType.SMITHING, this.input, this.world);
        if (list.isEmpty()) {
            this.output.setStack(0, ItemStack.EMPTY);
        } else if(this.input.getStack(1).isIn(ModItemTags.TABLES_INGREDIENTS)){
            if(!this.input.getStack(3).isEmpty()){
                if(diamond){
                    if(getHammer().isIn(ModItemTags.DIAMOND_HAMMERS)){
                        if(this.input.getStack(1).isOf(Items.IRON_NUGGET)){
                            if(this.input.getStack(1).getCount() >=3) showItem(list);
                        }
                        else if(this.input.getStack(1).isOf(Items.GOLD_NUGGET)){
                            if(this.input.getStack(1).getCount() >=3) showItem(list);
                        }
                        else showItem(list);
                    }
                    else if(getHammer().isIn(ModItemTags.GOLDEN_HAMMERS)) goldCraft(list);
                    else if(getHammer().isIn(ModItemTags.IRON_HAMMERS)) ironCraft(list);
                    else copperCraft(list);
                }
                else if(gold){
                    if(getHammer().isIn(ModItemTags.GOLDEN_HAMMERS)) goldCraft(list);
                    else if(getHammer().isIn(ModItemTags.IRON_HAMMERS)) ironCraft(list);
                    else copperCraft(list);
                }
                else if(iron){
                    if(getHammer().isIn(ModItemTags.IRON_HAMMERS)) ironCraft(list);
                    else copperCraft(list);
                }
                else if(copper){
                    copperCraft(list);
                }
                else{
                    showItem(list);
                }
            }
        }
        else showItem(list);
    }

    protected boolean isUsableAsAddition(ItemStack stack) {
        return this.recipes.stream().anyMatch((recipe) -> {
            return recipe.testAddition(stack);
        });
    }

    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.output && super.canInsertIntoSlot(stack, slot);
    }
}
