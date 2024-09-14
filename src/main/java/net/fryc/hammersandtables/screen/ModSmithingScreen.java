package net.fryc.hammersandtables.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.CyclingSlotIcon;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerInventory;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.List;
import java.util.Optional;


@Environment(EnvType.CLIENT)
public class ModSmithingScreen extends ForgingScreen<ModSmithingScreenHandler> {

    private static final Identifier TEXTURE = Identifier.of(HammersAndTables.MOD_ID,"textures/gui/mod_smithing.png");
    private static final Identifier EMPTY_SLOT_SMITHING_TEMPLATE_ARMOR_TRIM_TEXTURE = Identifier.of("item/empty_slot_smithing_template_armor_trim");
    private static final Identifier EMPTY_SLOT_SMITHING_TEMPLATE_NETHERITE_UPGRADE_TEXTURE = Identifier.of("item/empty_slot_smithing_template_netherite_upgrade");
    private static final Text MISSING_TEMPLATE_TOOLTIP = Text.translatable("container.upgrade.missing_template_tooltip");
    private static final Text WRONG_SMITHING_TABLE_TOOLTIP = Text.translatable("container.upgrade.wrong_smithing_table_tooltip");
    private static final Text WRONG_ADDITION_COUNT_TOOLTIP = Text.translatable("container.upgrade.wrong_addition_count_tooltip");
    private static final Text WRONG_HAMMER_TOOLTIP = Text.translatable("container.upgrade.wrong_hammer_tooltip");
    private static final List<Identifier> EMPTY_SLOT_TEXTURES;
    private static final Vector3f field_45497;
    public static final Quaternionf ARMOR_STAND_ROTATION;

    private final CyclingSlotIcon templateSlotIcon = new CyclingSlotIcon(0);
    private final CyclingSlotIcon baseSlotIcon = new CyclingSlotIcon(1);
    private final CyclingSlotIcon additionsSlotIcon = new CyclingSlotIcon(2);
    @Nullable
    private ArmorStandEntity armorStand;

    public ModSmithingScreen(ModSmithingScreenHandler handler, PlayerInventory playerInventory, Text title) {
        super(handler, playerInventory, title, TEXTURE);
        this.titleX = 44;
        this.titleY = 15;
    }

    protected void setup() {
        this.armorStand = new ArmorStandEntity(this.client.world, 0.0, 0.0, 0.0);
        this.armorStand.setHideBasePlate(true);
        this.armorStand.setShowArms(true);
        this.armorStand.bodyYaw = 210.0F;
        this.armorStand.setPitch(25.0F);
        this.armorStand.headYaw = this.armorStand.getYaw();
        this.armorStand.prevHeadYaw = this.armorStand.getYaw();
        this.equipArmorStand(((ModSmithingScreenHandler)this.handler).getSlot(4).getStack());
    }

    public void handledScreenTick() {
        super.handledScreenTick();
        Optional<SmithingTemplateItem> optional = this.getSmithingTemplate();
        this.templateSlotIcon.updateTexture(EMPTY_SLOT_TEXTURES);
        this.baseSlotIcon.updateTexture((List)optional.map(SmithingTemplateItem::getEmptyBaseSlotTextures).orElse(List.of()));
        this.additionsSlotIcon.updateTexture((List)optional.map(SmithingTemplateItem::getEmptyAdditionsSlotTextures).orElse(List.of()));
        if(this.handler.getSlot(4).hasStack()) this.equipArmorStand(this.handler.getSlot(4).getStack());
    }

    private Optional<SmithingTemplateItem> getSmithingTemplate() {
        ItemStack itemStack = ((ModSmithingScreenHandler)this.handler).getSlot(0).getStack();
        if (!itemStack.isEmpty()) {
            Item var3 = itemStack.getItem();
            if (var3 instanceof SmithingTemplateItem) {
                SmithingTemplateItem smithingTemplateItem = (SmithingTemplateItem)var3;
                return Optional.of(smithingTemplateItem);
            }
        }

        return Optional.empty();
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.renderSlotTooltip(context, mouseX, mouseY);
    }

    /* old
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        super.drawBackground(context, delta, mouseX, mouseY);
        this.templateSlotIcon.render(this.handler, context, delta, this.x, this.y);
        this.baseSlotIcon.render(this.handler, context, delta, this.x, this.y);
        this.additionsSlotIcon.render(this.handler, context, delta, this.x, this.y);
        InventoryScreen.drawEntity(context, this.x + 141, this.y + 75, 25, ARMOR_STAND_ROTATION, (Quaternionf)null, this.armorStand);
    }

     */

    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        super.drawBackground(context, delta, mouseX, mouseY);
        this.templateSlotIcon.render(this.handler, context, delta, this.x, this.y);
        this.baseSlotIcon.render(this.handler, context, delta, this.x, this.y);
        this.additionsSlotIcon.render(this.handler, context, delta, this.x, this.y);
        InventoryScreen.drawEntity(context, (float)(this.x + 141), (float)(this.y + 75), 25, field_45497, ARMOR_STAND_ROTATION, (Quaternionf)null, this.armorStand);
    }


    public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
        if (slotId == 4) {
            this.equipArmorStand(stack);
        }

    }

    private void equipArmorStand(ItemStack stack) {
        if (this.armorStand != null) {
            EquipmentSlot[] var2 = EquipmentSlot.values();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                EquipmentSlot equipmentSlot = var2[var4];
                this.armorStand.equipStack(equipmentSlot, ItemStack.EMPTY);
            }

            if (!stack.isEmpty()) {
                ItemStack itemStack = stack.copy();
                Item var8 = stack.getItem();
                if (var8 instanceof ArmorItem) {
                    ArmorItem armorItem = (ArmorItem)var8;
                    this.armorStand.equipStack(armorItem.getSlotType(), itemStack);
                } else {
                    this.armorStand.equipStack(EquipmentSlot.OFFHAND, itemStack);
                }
            }

        }
    }
    protected void drawInvalidRecipeArrow(DrawContext context, int x, int y) {
        if (this.hasInvalidRecipe() || this.hasInvalidHammer() || this.hasInvalidAdditionCount()) {
            context.drawTexture(TEXTURE, x + 65, y + 46, this.backgroundWidth, 0, 28, 21);
        }
    }

    private void renderSlotTooltip(DrawContext context, int mouseX, int mouseY) {
        Optional<Text> optional = Optional.empty();
        if (this.hasInvalidRecipe() && this.isPointWithinBounds(65, 46, 28, 21, (double)mouseX, (double)mouseY)) {
            optional = Optional.of(WRONG_SMITHING_TABLE_TOOLTIP);
        }
        //count
        if (this.hasInvalidAdditionCount() && this.isPointWithinBounds(65, 46, 28, 21, (double)mouseX, (double)mouseY)) {
            optional = Optional.of(WRONG_ADDITION_COUNT_TOOLTIP);
        }
        //hammer
        if (this.hasInvalidHammer() && this.isPointWithinBounds(65, 46, 28, 21, (double)mouseX, (double)mouseY)) {
            optional = Optional.of(WRONG_HAMMER_TOOLTIP);
        }

        if (this.focusedSlot != null) {
            ItemStack itemStack = ((ModSmithingScreenHandler)this.handler).getSlot(0).getStack();
            ItemStack itemStack2 = this.focusedSlot.getStack();
            if (itemStack.isEmpty()) {
                if (this.focusedSlot.id == 0) {
                    optional = Optional.of(MISSING_TEMPLATE_TOOLTIP);
                }
            } else {
                Item var8 = itemStack.getItem();
                if (var8 instanceof SmithingTemplateItem) {
                    SmithingTemplateItem smithingTemplateItem = (SmithingTemplateItem)var8;
                    if (itemStack2.isEmpty()) {
                        if (this.focusedSlot.id == 1) {
                            optional = Optional.of(smithingTemplateItem.getBaseSlotDescription());
                        } else if (this.focusedSlot.id == 2) {
                            optional = Optional.of(smithingTemplateItem.getAdditionsSlotDescription());
                        } else if (this.focusedSlot.id == 3) {
                            optional = Optional.of(Text.translatable("container.upgrade.hammer_slot_decription"));
                        }
                    }
                }
            }
        }

        optional.ifPresent((text) -> {
            context.drawOrderedTooltip(this.textRenderer, this.textRenderer.wrapLines(text, 115), mouseX, mouseY);
        });
    }

    private boolean hasInvalidHammer() {
        return ((ModSmithingScreenHandler)this.handler).getSlot(((ModSmithingScreenHandler)this.handler).getResultSlotIndex()).hasStack() && !((ModSmithingScreenHandler)this.handler).hasCorrectHammer();
    }
    private boolean hasInvalidAdditionCount() {
        return ((ModSmithingScreenHandler)this.handler).getSlot(((ModSmithingScreenHandler)this.handler).getResultSlotIndex()).hasStack() && !((ModSmithingScreenHandler)this.handler).hasCorrectAdditionCount();
    }
    private boolean hasInvalidRecipe() {
        return ((ModSmithingScreenHandler)this.handler).getSlot(0).hasStack() && ((ModSmithingScreenHandler)this.handler).getSlot(1).hasStack() && ((ModSmithingScreenHandler)this.handler).getSlot(2).hasStack() && !((ModSmithingScreenHandler)this.handler).getSlot(((ModSmithingScreenHandler)this.handler).getResultSlotIndex()).hasStack();
    }

    static {
        EMPTY_SLOT_TEXTURES = List.of(EMPTY_SLOT_SMITHING_TEMPLATE_ARMOR_TRIM_TEXTURE, EMPTY_SLOT_SMITHING_TEMPLATE_NETHERITE_UPGRADE_TEXTURE);
        field_45497 = new Vector3f();
        ARMOR_STAND_ROTATION = (new Quaternionf()).rotationXYZ(0.43633232F, 0.0F, 3.1415927F);
    }
}
