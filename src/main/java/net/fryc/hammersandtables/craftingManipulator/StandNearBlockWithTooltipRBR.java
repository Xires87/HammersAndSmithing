package net.fryc.hammersandtables.craftingManipulator;

import net.fryc.craftingmanipulator.rules.recipeblocking.StandNearBlockRBR;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class StandNearBlockWithTooltipRBR extends StandNearBlockRBR {

    public final Text tooltipOnScreen;
    public StandNearBlockWithTooltipRBR(@Nullable TagKey<Item> needsCopperSmithingTable, @Nullable TagKey<Block> tables, Text tooltipOnScreen) {
        super(needsCopperSmithingTable, tables);
        this.tooltipOnScreen = tooltipOnScreen;
    }

    public StandNearBlockWithTooltipRBR(Text tooltipOnScreen) {
        this(null, null, tooltipOnScreen);
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
