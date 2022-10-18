package net.fryc.hammersandtables.unused;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fryc.hammersandtables.villagers.ModTradeOffers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.InteractionObserver;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerDataContainer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Old file
 * I didn't know that trade offers can be so easily overwritten (and without mixins)
 */

@Mixin(VillagerEntity.class)
abstract class VillagerEntityMixin extends MerchantEntity implements InteractionObserver, VillagerDataContainer {

    public VillagerEntityMixin(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    //Overwrites vanilla trade offers for Armorer, Toolsmith, Weaponsmith and Librarian
    @ModifyVariable(method = "fillRecipes()V", at = @At("STORE"))
    private Int2ObjectMap<TradeOffers.Factory[]> injected(Int2ObjectMap<TradeOffers.Factory[]> int2ObjectMap) {
        if(int2ObjectMap != null){
            VillagerData villagerData = ((VillagerEntity)(Object)this).getVillagerData();
            if((villagerData.getProfession() == VillagerProfession.ARMORER || villagerData.getProfession() == VillagerProfession.TOOLSMITH ||
                      villagerData.getProfession() == VillagerProfession.WEAPONSMITH) || (villagerData.getProfession() == VillagerProfession.LIBRARIAN)){
                int2ObjectMap = ModTradeOffers.PROFESSION_TO_LEVELED_TRADE.get(villagerData.getProfession());
            }
        }
        return int2ObjectMap;
    }


}
