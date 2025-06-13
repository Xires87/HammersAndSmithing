package net.fryc.hammersandtables.craftingManipulator;

import net.fryc.hammersandtables.items.ModItems;
import net.minecraft.item.Item;

import java.util.HashSet;
import java.util.List;

public enum RuleTier {

    NONE {
        final HashSet<Item> set = new HashSet<>();

        @Override
        public HashSet<Item> getUnlockItems() {
            return this.set;
        }
    },
    COPPER {
        final HashSet<Item> set = new HashSet<>(List.of(
                ModItems.IRON_CRAFTING_KIT,
                ModItems.GOLDEN_CRAFTING_KIT,
                ModItems.DIAMOND_CRAFTING_KIT
        ));

        @Override
        public HashSet<Item> getUnlockItems() {
            return this.set;
        }
    },
    IRON {
        final HashSet<Item> set = new HashSet<>(List.of(
                ModItems.GOLDEN_CRAFTING_KIT,
                ModItems.DIAMOND_CRAFTING_KIT
        ));

        @Override
        public HashSet<Item> getUnlockItems() {
            return this.set;
        }
    },
    GOLD {
        final HashSet<Item> set = new HashSet<>(List.of(
                ModItems.DIAMOND_CRAFTING_KIT
        ));

        @Override
        public HashSet<Item> getUnlockItems() {
            return this.set;
        }
    },
    DIAMOND {
        final HashSet<Item> set = new HashSet<>();

        @Override
        public HashSet<Item> getUnlockItems() {
            return this.set;
        }
    };

    public abstract HashSet<Item> getUnlockItems();
}
