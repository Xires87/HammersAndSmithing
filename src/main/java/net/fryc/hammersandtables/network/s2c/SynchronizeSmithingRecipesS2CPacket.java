package net.fryc.hammersandtables.network.s2c;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fryc.hammersandtables.recipes.ModSmithingRecipes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

import java.util.HashMap;


public class SynchronizeSmithingRecipesS2CPacket {

    //reading map containing all additional variables for smithing recipes
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        ModSmithingRecipes.smithingAdditionalVariables = ((HashMap<Integer, int[]>) buf.readMap(PacketByteBuf::readInt, PacketByteBuf::readIntArray));
    }
}
