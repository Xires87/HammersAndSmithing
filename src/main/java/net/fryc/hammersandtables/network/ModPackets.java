package net.fryc.hammersandtables.network;


import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.network.s2c.SynchronizeSmithingRecipesS2CPacket;
import net.minecraft.util.Identifier;

public class ModPackets {

    public static final Identifier HAMMERS_AND_SMITHING_NETWORKING = new Identifier(HammersAndTables.MOD_ID, "hammers_and_smithing_networking");

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.HAMMERS_AND_SMITHING_NETWORKING, SynchronizeSmithingRecipesS2CPacket::receive);
    }


}
