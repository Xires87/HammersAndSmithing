package net.fryc.hammersandtables.recipes;

public interface SmithingAdditionalVariables {

    void setHammerTier(int tier);
    void setTableTier(int tier);
    void setAdditionCount(int count);

    int getHammerTier();
    int getTableTier();
    int getAdditionCount();
}
