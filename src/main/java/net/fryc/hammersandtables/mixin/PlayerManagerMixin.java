package net.fryc.hammersandtables.mixin;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.network.ModPackets;
import net.fryc.hammersandtables.recipes.ModSmithingRecipes;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
abstract class PlayerManagerMixin {

    @Inject(method = "onPlayerConnect(Lnet/minecraft/network/ClientConnection;Lnet/minecraft/server/network/ServerPlayerEntity;Lnet/minecraft/server/network/ConnectedClientData;)V", at = @At("HEAD"))
    private void informPlayerAboutSmithingRecipes(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo info) {
        //sending server's map to client
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeMap(ModSmithingRecipes.smithingAdditionalVariables, PacketByteBuf::writeInt, PacketByteBuf::writeIntArray);
        connection.send(ServerPlayNetworking.createS2CPacket(ModPackets.HAMMERS_AND_SMITHING_NETWORKING, buf));

        //sending some server's config options to client
        PacketByteBuf sBuf = PacketByteBufs.create();
        sBuf.writeBoolean(HammersAndTables.config.isCopperRecipeBlocked);
        sBuf.writeBoolean(HammersAndTables.config.isIronRecipeBlocked);
        sBuf.writeBoolean(HammersAndTables.config.isGoldRecipeBlocked);
        sBuf.writeBoolean(HammersAndTables.config.isDiamondRecipeBlocked);
        sBuf.writeBoolean(HammersAndTables.config.isVanillaGoldenRecipeBlocked);
        connection.send(ServerPlayNetworking.createS2CPacket(ModPackets.HAMMERS_AND_SMITHING_SYNCHRONIZE_CONFIG, sBuf));
    }

}
