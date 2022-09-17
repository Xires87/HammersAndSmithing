package net.fryc.hammersandtables.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fryc.hammersandtables.mixhelpers.ModTradeOffers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.InteractionObserver;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerDataContainer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VillagerEntity.class)
abstract class VillagerEntityMixin extends MerchantEntity implements InteractionObserver, VillagerDataContainer {


    public VillagerEntityMixin(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    //Overwrites vanilla trade offers
    @Override
    public void fillRecipes() {
        VillagerData villagerData = this.getVillagerData();
        Int2ObjectMap<ModTradeOffers.Factory[]> int2ObjectMap = (Int2ObjectMap) ModTradeOffers.PROFESSION_TO_LEVELED_TRADE.get(villagerData.getProfession());
        if (int2ObjectMap != null && !int2ObjectMap.isEmpty()) {
            ModTradeOffers.Factory[] factorys = (ModTradeOffers.Factory[])int2ObjectMap.get(villagerData.getLevel());
            if (factorys != null) {
                TradeOfferList tradeOfferList = this.getOffers();
                this.fillRecipesFromPool(tradeOfferList, factorys, 2);
            }
        }
    }

}
