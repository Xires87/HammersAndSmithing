package net.fryc.hammersandtables.screen;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static final ScreenHandlerType<ModSmithingScreenHandler> MOD_SMITHING_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER, Identifier.of(HammersAndTables.MOD_ID, "hns_smithing_screen_handler"),
            new ScreenHandlerType<>(ModSmithingScreenHandler::new, FeatureFlags.VANILLA_FEATURES)
    );

    public static void registerScreenHandlers() {

    }

    public static void registerScreenHandlersClient(){
        HandledScreens.register(ModScreenHandlers.MOD_SMITHING_SCREEN_HANDLER, ModSmithingScreen::new);
    }
}
