package net.fryc.hammersandtables.mixin;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fryc.hammersandtables.network.payloads.SynchronizeSmithingRecipesPayload;
import net.fryc.hammersandtables.recipes.ModSmithingRecipes;
import net.minecraft.network.ClientConnection;
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
        connection.send(ServerPlayNetworking.createS2CPacket(new SynchronizeSmithingRecipesPayload(ModSmithingRecipes.smithingAdditionalVariables)));

    }

}
