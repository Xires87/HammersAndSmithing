package net.fryc.hammersandtables.screen;

import net.fryc.hammersandtables.tag.ModItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public abstract class ModForgingScreenHandler extends ScreenHandler {
    public static final int FIRST_INPUT_SLOT_INDEX = 0;
    public static final int SECOND_INPUT_SLOT_INDEX = 1;
    public static final int OUTPUT_SLOT_INDEX = 2;
    private static final int PLAYER_INVENTORY_START_INDEX = 3;
    private static final int field_30817 = 30;
    private static final int field_30818 = 30;
    private static final int PLAYER_INVENTORY_END_INDEX = 39;
    protected final CraftingResultInventory output = new CraftingResultInventory();
    protected final Inventory input = new SimpleInventory(4) {
        public void markDirty() {
            super.markDirty();
            ModForgingScreenHandler.this.onContentChanged(this);
        }
    };
    protected final ScreenHandlerContext context;
    protected final PlayerEntity player;

    protected abstract boolean canTakeOutput(PlayerEntity player, boolean present);

    protected abstract void onTakeOutput(PlayerEntity player, ItemStack stack);

    protected abstract boolean canUse(BlockState state);

    public ModForgingScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId);
        this.context = context;
        this.player = playerInventory.player;
        this.addSlot(new Slot(this.input, 0, 27, 47));
        this.addSlot(new Slot(this.input, 1, 76, 47));
        this.addSlot(new Slot(this.input, 3, 105, 26){
            public boolean canTakeItems(PlayerEntity playerEntity) {
                return !ModForgingScreenHandler.this.canTakeOutput(playerEntity, this.hasStack());
            }
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(ModItemTags.HAMMERS);
            }
        });
        this.addSlot(new Slot(this.output, 2, 134, 47) {
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            public boolean canTakeItems(PlayerEntity playerEntity) {
                return ModForgingScreenHandler.this.canTakeOutput(playerEntity, this.hasStack());
            }

            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                ModForgingScreenHandler.this.onTakeOutput(player, stack);
            }
        });

        int i;
        for(i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

    }

    public abstract void updateResult();

    public void onContentChanged(Inventory inventory) {
        super.onContentChanged(inventory);
        if (inventory == this.input) {
            this.updateResult();
        }

    }

    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> {
            this.dropInventory(player, this.input);
        });
    }

    public boolean canUse(PlayerEntity player) {
        return (Boolean)this.context.get((world, pos) -> {
            return !this.canUse(world.getBlockState(pos)) ? false : player.squaredDistanceTo((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5) <= 64.0;
        }, true);
    }

    protected boolean isUsableAsAddition(ItemStack stack) {
        return false;
    }

    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = (Slot)this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot == 2) {
                if (!this.insertItem(itemStack2, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot != 0 && slot != 1) {
                if (slot >= 3 && slot < 39) {
                    int i = this.isUsableAsAddition(itemStack) ? 1 : 0;
                    if (!this.insertItem(itemStack2, i, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.insertItem(itemStack2, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
        }

        return itemStack;
    }
}
