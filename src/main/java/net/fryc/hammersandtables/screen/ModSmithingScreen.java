package net.fryc.hammersandtables.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ModSmithingScreen extends ModForgingScreen<ModSmithingScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(HammersAndTables.MOD_ID, "textures/gui/mod_smithing.png");

    public ModSmithingScreen(ModSmithingScreenHandler handler, PlayerInventory playerInventory, Text title) {
        super(handler, playerInventory, title, TEXTURE);
        this.titleX = 60;
        this.titleY = 10;
    }

    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        RenderSystem.disableBlend();
        super.drawForeground(matrices, mouseX, mouseY);
    }
}
