package net.fryc.hammersandtables.mixin;

import net.fryc.hammersandtables.util.interfaces.TicksInventory;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin implements TicksInventory {

    private int inventoryTickDelay = 0;
    private boolean canDecrementDelay = true;

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void canDecreaseDelayOncePerTick(CallbackInfo info) {
        this.canDecrementDelay = true;
    }

    @Override
    public void setTickDelay(int delay) {
        this.inventoryTickDelay = delay;
    }

    @Override
    public void decrementTickDelay() {
        if(this.canDecrementDelay){
            this.inventoryTickDelay--;
            this.canDecrementDelay = false;
        }
    }

    @Override
    public int getTickDelay() {
        return this.inventoryTickDelay;
    }
}
