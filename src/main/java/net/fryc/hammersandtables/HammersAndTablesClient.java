package net.fryc.hammersandtables;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fryc.hammersandtables.config.HammersAndTablesConfigClient;
import net.fryc.hammersandtables.network.ModPackets;
import net.fryc.hammersandtables.screen.ModScreenHandlers;

public class HammersAndTablesClient implements ClientModInitializer {

    public static HammersAndTablesConfigClient config;

    @Override
    public void onInitializeClient() {
        //config
        AutoConfig.register(HammersAndTablesConfigClient.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(HammersAndTablesConfigClient.class).getConfig();

        ModScreenHandlers.registerScreenHandlersClient();
        ModPackets.registerS2CPackets();

    }
}
