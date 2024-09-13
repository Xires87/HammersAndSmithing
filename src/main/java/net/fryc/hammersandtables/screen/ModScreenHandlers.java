package net.fryc.hammersandtables.screen;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {

    public static final ScreenHandlerType<ModSmithingScreenHandler> MOD_SMITHING_SCREEN_HANDLER = register(HammersAndTables.MOD_ID, ModSmithingScreenHandler::new);

    public static void registerScreenHandlers() {

    }

    public static void registerScreenHandlersClient(){
        HandledScreens.register(ModScreenHandlers.MOD_SMITHING_SCREEN_HANDLER, ModSmithingScreen::new);
    }

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return (ScreenHandlerType) Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType(factory, FeatureFlags.VANILLA_FEATURES));
    }
}
