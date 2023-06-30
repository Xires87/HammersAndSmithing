package net.fryc.hammersandtables.util;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

public interface SmithingTransformAdditionalVariables {

    void setHammerTier(int tier);
    void setTableTier(int tier);
    void setAdditionCount(int count);

    int getHammerTier();
    int getTableTier();
    int getAdditionCount();

    Ingredient getSmithingTemplate();
    Ingredient getSmithingBase();
    Ingredient getSmithingAddition();
    ItemStack getSmithingResult();
}
