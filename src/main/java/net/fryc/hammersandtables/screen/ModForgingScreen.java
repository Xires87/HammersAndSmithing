package net.fryc.hammersandtables.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ModForgingScreen<T extends ModForgingScreenHandler> extends HandledScreen<T> implements ScreenHandlerListener {
    private final Identifier texture;

    public ModForgingScreen(T handler, PlayerInventory playerInventory, Text title, Identifier texture) {
        super(handler, playerInventory, title);
        this.texture = texture;
    }

    protected void setup() {
    }

    protected void init() {
        super.init();
        this.setup();
        ((ModForgingScreenHandler)this.handler).addListener(this);
    }

    public void removed() {
        super.removed();
        ((ModForgingScreenHandler)this.handler).removeListener(this);
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        RenderSystem.disableBlend();
        this.renderForeground(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    protected void renderForeground(MatrixStack matrices, int mouseX, int mouseY, float delta) {
    }

    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.texture);
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        this.drawTexture(matrices, i + 59, j + 20, 0, this.backgroundHeight + (((ModForgingScreenHandler)this.handler).getSlot(0).hasStack() ? 0 : 16), 110, 16);
        /* draws red X (doesnt work properly)
        if ((((ForgingScreenHandler)this.handler).getSlot(0).hasStack() || ((ForgingScreenHandler)this.handler).getSlot(1).hasStack()) && !((ForgingScreenHandler)this.handler).getSlot(2).hasStack()) {
            this.drawTexture(matrices, i + 99, j + 45, this.backgroundWidth, 0, 28, 21);
        }

         */

    }

    public void onPropertyUpdate(ScreenHandler handler, int property, int value) {
    }

    public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
    }
}
