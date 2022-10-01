package net.fryc.hammersandtables.gamerules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {

    public static GameRules.Key<GameRules.BooleanRule> OVERWITE_TOOL_TRADE_OFFERS;
    public static GameRules.Key<GameRules.BooleanRule> OVERWITE_LIBRARIAN_TRADE_OFFERS;
    public static GameRules.Key<GameRules.BooleanRule> BLOCK_COPPER_RECIPES;
    public static GameRules.Key<GameRules.BooleanRule> BLOCK_IRON_RECIPES;
    public static GameRules.Key<GameRules.BooleanRule> BLOCK_GOLDEN_RECIPES;
    public static GameRules.Key<GameRules.BooleanRule> BLOCK_DIAMOND_RECIPES;
    public static void registerGameRules(){
        OVERWITE_TOOL_TRADE_OFFERS = GameRuleRegistry.register("overwriteToolTradeOffers", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
        OVERWITE_LIBRARIAN_TRADE_OFFERS = GameRuleRegistry.register("overwriteLibrarianTradeOffers", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));

        BLOCK_COPPER_RECIPES = GameRuleRegistry.register("blockCopperRecipes", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
        BLOCK_IRON_RECIPES = GameRuleRegistry.register("blockIronRecipes", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
        BLOCK_GOLDEN_RECIPES = GameRuleRegistry.register("blockGoldenRecipes", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
        BLOCK_DIAMOND_RECIPES = GameRuleRegistry.register("blockDiamondRecipes", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
    }
}
