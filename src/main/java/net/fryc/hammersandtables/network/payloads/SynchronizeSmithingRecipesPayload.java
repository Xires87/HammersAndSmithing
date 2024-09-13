package net.fryc.hammersandtables.network.payloads;

import net.fryc.hammersandtables.network.ModPackets;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public record SynchronizeSmithingRecipesPayload(HashMap<Integer, List<Integer>> map) implements CustomPayload {

    public static final Id<SynchronizeSmithingRecipesPayload> ID = new Id<>(ModPackets.SYNCHRONIZE_CONFIG_ID);
    public static final PacketCodec<RegistryByteBuf, SynchronizeSmithingRecipesPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.map(HashMap::new, PacketCodecs.INTEGER, PacketCodecs.collection(ArrayList::new, PacketCodecs.INTEGER)), SynchronizeSmithingRecipesPayload::map,
            SynchronizeSmithingRecipesPayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}