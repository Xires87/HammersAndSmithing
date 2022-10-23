package net.fryc.hammersandtables.mixin;

import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.gamerules.ModGameRules;
import net.fryc.hammersandtables.tag.ModBlockTags;
import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(CraftingScreenHandler.class)
abstract class CraftingScreenHandlerMixin extends AbstractRecipeScreenHandler<CraftingInventory> {
    public CraftingScreenHandlerMixin(ScreenHandlerType<?> screenHandlerType, int i) {
        super(screenHandlerType, i);
    }

    private static boolean diamond;
    private static boolean gold;
    private static boolean iron;
    private static boolean copper;

    //blocks recipes
    @ModifyVariable(method = "updateResult(Lnet/minecraft/screen/ScreenHandler;" +
            "Lnet/minecraft/world/World;" +
            "Lnet/minecraft/entity/player/PlayerEntity;" +
            "Lnet/minecraft/inventory/CraftingInventory;" +
            "Lnet/minecraft/inventory/CraftingResultInventory;)V",
            at = @At(value = "STORE", ordinal = 1))
    private static ItemStack blockRecipe(ItemStack stack , ScreenHandler handler, World world, PlayerEntity player, CraftingInventory craftingInventory, CraftingResultInventory resultInventory) {
        copper = false; iron = false; gold = false; diamond = false;
        findTableNearby(world, player);
        if(!diamond){
            if(!gold){
                if(!iron){
                    if(!copper){
                        if((stack.isIn(ModItemTags.NEEDS_COPPER_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_COPPER_RECIPES)) ||
                                (stack.isIn(ModItemTags.NEEDS_IRON_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_IRON_RECIPES)) ||
                                (stack.isIn(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_GOLDEN_RECIPES)) ||
                                (stack.isIn(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_DIAMOND_RECIPES))){
                            stack = ItemStack.EMPTY;
                        }
                    }
                    else{
                        if((stack.isIn(ModItemTags.NEEDS_IRON_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_IRON_RECIPES)) ||
                                (stack.isIn(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_GOLDEN_RECIPES)) ||
                                (stack.isIn(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_DIAMOND_RECIPES))){
                            stack = ItemStack.EMPTY;
                        }
                    }
                }
                else{
                    if((stack.isIn(ModItemTags.NEEDS_GOLDEN_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_GOLDEN_RECIPES)) ||
                            (stack.isIn(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_DIAMOND_RECIPES))){
                        stack = ItemStack.EMPTY;
                    }
                }
            }
            else{
                if(stack.isIn(ModItemTags.NEEDS_DIAMOND_SMITHING_TABLE) && world.getGameRules().getBoolean(ModGameRules.BLOCK_DIAMOND_RECIPES)){
                    stack = ItemStack.EMPTY;
                }
            }
        }

        return stack;
    }



    //finds smithing tables
    private static void findTableNearby(WorldView world, PlayerEntity player) {
        BlockPos pos = player.getBlockPos();
        for (BlockPos blockPos : BlockPos.iterate(pos.add(-5, -2, -5), pos.add(5, 3, 5))) {
            if (world.getBlockState(blockPos).isIn(ModBlockTags.TABLES)){
                if(world.getBlockState(blockPos).isOf(ModBlocks.DIAMOND_TABLE)) {
                    diamond = true;
                    break;
                }
                else if(world.getBlockState(blockPos).isOf(ModBlocks.GOLD_TABLE)) gold = true;
                else if(world.getBlockState(blockPos).isOf(ModBlocks.IRON_TABLE)) iron = true;
                else if(world.getBlockState(blockPos).isOf(ModBlocks.COPPER_TABLE)) copper = true;
            }
        }
    }
}
