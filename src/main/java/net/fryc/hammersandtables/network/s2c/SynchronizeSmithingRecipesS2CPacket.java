package net.fryc.hammersandtables.network.s2c;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fryc.hammersandtables.network.payloads.SynchronizeSmithingRecipesPayload;
import net.fryc.hammersandtables.recipes.ModSmithingRecipes;
import net.fryc.hammersandtables.util.TransformRecipeNumber;


public class SynchronizeSmithingRecipesS2CPacket {

    //reading map containing all additional variables for smithing recipes
    public static void receive(SynchronizeSmithingRecipesPayload payload, ClientPlayNetworking.Context context){
        ModSmithingRecipes.smithingAdditionalVariables = payload.map();
        TransformRecipeNumber.number = 0;
    }
}
