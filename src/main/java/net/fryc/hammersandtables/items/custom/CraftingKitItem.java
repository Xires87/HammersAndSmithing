package net.fryc.hammersandtables.items.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class CraftingKitItem extends MasterToolsItem {

    public final String forMaterial;

    public CraftingKitItem(Settings settings, String forMaterial) {
        super(settings);
        this.forMaterial = forMaterial;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("text.hammersandtables.item.craftingKit.for." + this.forMaterial));
    }
}
