package net.fryc.hammersandtables.craftingManipulator;

import net.fryc.craftingmanipulator.rules.oncraft.PlaySoundOCR;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.BlastFurnaceScreenHandler;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.Nullable;

public class PlaySmeltingSoundOCR extends PlaySoundOCR {

    public PlaySmeltingSoundOCR(@Nullable TagKey<Item> ruleItems, SoundEvent sound, float volume, float pitch) {
        super(ruleItems, sound, volume, pitch);
    }

    public PlaySmeltingSoundOCR(SoundEvent sound, float volume, float pitch) {
        super(sound, volume, pitch);
    }

    @Override
    public boolean isInAppriopriateScreenHandler(ScreenHandler handler) {
        return handler.getClass() == BlastFurnaceScreenHandler.class || handler.getClass() == FurnaceScreenHandler.class;
    }

}
