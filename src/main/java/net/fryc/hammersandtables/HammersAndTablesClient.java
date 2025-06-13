package net.fryc.hammersandtables;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fryc.hammersandtables.config.HammersAndTablesConfigClient;
import net.fryc.hammersandtables.items.ModItems;
import net.fryc.hammersandtables.screen.ModScreenHandlers;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.util.math.ColorHelper;

public class HammersAndTablesClient implements ClientModInitializer {

    public static HammersAndTablesConfigClient config;

    @Override
    public void onInitializeClient() {
        //config
        AutoConfig.register(HammersAndTablesConfigClient.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(HammersAndTablesConfigClient.class).getConfig();

        ModScreenHandlers.registerScreenHandlersClient();

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if(tintIndex == 0){
                var component = stack.getComponents().get(DataComponentTypes.DYED_COLOR);
                if(component != null){
                    return ColorHelper.Argb.fullAlpha(component.rgb());
                }
                return ColorHelper.Argb.fullAlpha(-6265536);
            }
            return ColorHelper.Argb.fullAlpha(0xFFFFFF);
        }, ModItems.BONE_CHESTPLATE, ModItems.BONE_HELMET, ModItems.BONE_BOOTS, ModItems.BONE_LEGGINGS);
    }
}
