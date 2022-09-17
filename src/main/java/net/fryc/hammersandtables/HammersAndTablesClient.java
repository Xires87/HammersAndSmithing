package net.fryc.hammersandtables;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fryc.hammersandtables.screen.ModScreenHandlers;
import net.fryc.hammersandtables.screen.ModSmithingScreen;

public class HammersAndTablesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.MOD_SMITHING_SCREEN_HANDLER, ModSmithingScreen::new);
    }
}
