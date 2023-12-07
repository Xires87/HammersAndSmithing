package net.fryc.hammersandtables.network.s2c;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fryc.hammersandtables.craftingManipulator.ClientRules;
import net.fryc.hammersandtables.network.SynchronizedConfigOptions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;


public class SynchronizeConfigS2CPacket {

    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        SynchronizedConfigOptions.isCopperRecipeBlocked = buf.readBoolean();
        SynchronizedConfigOptions.isIronRecipeBlocked = buf.readBoolean();
        SynchronizedConfigOptions.isGoldRecipeBlocked = buf.readBoolean();
        SynchronizedConfigOptions.isDiamondRecipeBlocked = buf.readBoolean();
        SynchronizedConfigOptions.isVanillaGoldenRecipeBlocked = buf.readBoolean();
        ClientRules.setRulesStatus();
    }
}
