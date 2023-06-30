package net.fryc.hammersandtables.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static ScreenHandlerType<ModSmithingScreenHandler> MOD_SMITHING_SCREEN_HANDLER;

    public static void registerScreenHandlers() {

        MOD_SMITHING_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(HammersAndTables.MOD_ID),
                        ModSmithingScreenHandler::new);



    }
}
