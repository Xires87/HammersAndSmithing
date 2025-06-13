package net.fryc.hammersandtables.items.custom;

import net.minecraft.item.Item;

public class MasterToolsItem extends Item implements HasHammerTier {

    public MasterToolsItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getHammerTier() {
        return 5;
    }
}
