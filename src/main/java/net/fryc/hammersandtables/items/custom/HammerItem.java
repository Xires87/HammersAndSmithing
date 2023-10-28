package net.fryc.hammersandtables.items.custom;

import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.items.ModToolMaterials;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;

public class HammerItem extends SwordItem {

    public final int tier;
    public HammerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        if(toolMaterial == ModToolMaterials.COPPER || toolMaterial == ModToolMaterials.NUGGET_COPPER) tier = 1;
        else if(toolMaterial == ModToolMaterials.INGOT_COPPER || toolMaterial == ModToolMaterials.NUGGET_IRON || toolMaterial == ToolMaterials.IRON) tier = 2;
        else if(toolMaterial == ModToolMaterials.INGOT_IRON || toolMaterial == ModToolMaterials.DIAMOND_GOLD || toolMaterial == ModToolMaterials.GOLD) tier = 3;
        else if(toolMaterial == ToolMaterials.DIAMOND || toolMaterial == ToolMaterials.NETHERITE) tier = 4;
        else tier = 0;
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 1),attacker);
        return super.postHit(stack, target, attacker);
    }

    public int getParryTicks(){
        return HammersAndTables.config.hammerParryTicks;
    }

    public float getMeleeDamageTakenAfterBlock(){
        return (float) HammersAndTables.config.hammerBlockMeleeDamageTaken/100;
    }

    public float getProjectileDamageTakenAfterBlock(){
        return (float) HammersAndTables.config.hammerBlockArrowDamageTaken/100;
    }

    public int getCooldownAfterParryAction(){
        return HammersAndTables.config.cooldownAfterHammerParryAction;
    }
    public int getCooldownAfterInterruptingBlockAction(){
        return HammersAndTables.config.cooldownAfterInterruptingHammerBlockAction;
    }
    public double getKnockbackAfterParryAction(){
        return HammersAndTables.config.hammerParryKnockbackStrength;
    }
    public int getSlownessAfterParryAction(){
        return HammersAndTables.config.hammerSlownessAfterParry;
    }
    public int getSlownessAmplifierAfterParryAction(){
        return HammersAndTables.config.hammerSlownessAfterParryAmplifier;
    }
    public int getWeaknessAfterParryAction(){
        return HammersAndTables.config.hammerWeaknessAfterParry;
    }
    public int getWeaknessAmplifierAfterParryAction(){
        return HammersAndTables.config.hammerWeaknessAfterParryAmplifier;
    }
    public int getDisarmedAfterParryAction(){
        return HammersAndTables.config.hammerDisarmAfterParry;
    }
}
