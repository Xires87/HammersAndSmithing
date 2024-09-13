package net.fryc.hammersandtables.network;


import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.network.payloads.SynchronizeSmithingRecipesPayload;
import net.fryc.hammersandtables.network.s2c.SynchronizeSmithingRecipesS2CPacket;
import net.minecraft.util.Identifier;

public class ModPackets {

    public static final Identifier SYNCHRONIZE_CONFIG_ID = Identifier.of(HammersAndTables.MOD_ID, "hammers_and_smithing_networking");

    public static void registerPayloads(){
        PayloadTypeRegistry.playS2C().register(SynchronizeSmithingRecipesPayload.ID, SynchronizeSmithingRecipesPayload.CODEC);
    }

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(SynchronizeSmithingRecipesPayload.ID, SynchronizeSmithingRecipesS2CPacket::receive);
    }


}
