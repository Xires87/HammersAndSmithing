package net.fryc.hammersandtables.craftingManipulator;

import net.fryc.craftingmanipulator.rules.recipeblocking.StandNearBlockRBR;
import net.fryc.craftingmanipulator.util.ConditionsHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class StandNearBlockWithTooltipRBR extends StandNearBlockRBR {

    private final RuleTier ruleTier;

    public final Text tooltipOnScreen;
    public StandNearBlockWithTooltipRBR(@Nullable TagKey<Item> needsCopperSmithingTable, @Nullable TagKey<Block> tables, Text tooltipOnScreen, RuleTier ruleTier) {
        super(needsCopperSmithingTable, tables);
        this.tooltipOnScreen = tooltipOnScreen;
        this.ruleTier = ruleTier;
    }


    @Override
    public ItemStack modifyCraftedItem(ItemStack craftedItem, ServerPlayerEntity player, ServerWorld world, ScreenHandler handler, RecipeInputInventory craftingInventory, CraftingResultInventory resultInventory) {
        if(!ConditionsHelper.hasCorrectItemInInventory(player, null, this.ruleTier.getUnlockItems())){
            craftedItem = super.modifyCraftedItem(craftedItem, player, world, handler, craftingInventory, resultInventory);
        }

        return craftedItem;
    }


    @Override
    public void drawRedCrossWhenNeeded(ItemStack craftedItem, ServerPlayerEntity player, ScreenHandler handler){
        if(craftedItem.isEmpty()){
            if(handler instanceof PlayerScreenHandler){
                this.informAboutItemModification(player, "inventory_red_x");
                this.drawMouseOverTooltip(player, this.tooltipOnScreen, 134, 28, 18, 15);
            }
            else {
                this.informAboutItemModification(player, "crafting_red_x");
                this.drawMouseOverTooltip(player, this.tooltipOnScreen, 87, 32, 28, 21);
            }
        }
    }

}
