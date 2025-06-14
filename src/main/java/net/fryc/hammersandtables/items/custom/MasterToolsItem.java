package net.fryc.hammersandtables.items.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class MasterToolsItem extends Item implements HasHammerTier {

    public MasterToolsItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("text.hammersandtables.item.master_tools"));
    }

    @Override
    public int getHammerTier() {
        return 5;
    }
}
