package net.fryc.hammersandtables.items.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record BadQualityComponent(float armor, float armorToughness, float attackDamage, float attackSpeed, float miningEfficiency) {

    public static final Codec<BadQualityComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.FLOAT.optionalFieldOf("armor", -1F).forGetter(BadQualityComponent::armor),
                Codec.FLOAT.optionalFieldOf("armorToughness", -1F).forGetter(BadQualityComponent::armorToughness),
                Codec.FLOAT.optionalFieldOf("attackDamage", -1F).forGetter(BadQualityComponent::attackDamage),
                Codec.FLOAT.optionalFieldOf("attackSpeed", -1F).forGetter(BadQualityComponent::attackSpeed),
                Codec.FLOAT.optionalFieldOf("miningEfficiency", -1F).forGetter(BadQualityComponent::miningEfficiency)
        ).apply(builder, BadQualityComponent::new);
    });
}
