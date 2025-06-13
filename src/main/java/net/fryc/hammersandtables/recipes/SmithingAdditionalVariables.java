package net.fryc.hammersandtables.recipes;

public interface SmithingAdditionalVariables {

    void setHammerTier(int tier);
    void setTableTier(int tier);
    void setAdditionCount(int count);
    void setHammerDamage(int damage);

    int getHammerTier();
    int getTableTier();
    int getAdditionCount();
    int getHammerDamage();
}
