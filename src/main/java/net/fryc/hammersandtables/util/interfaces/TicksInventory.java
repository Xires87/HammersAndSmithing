package net.fryc.hammersandtables.util.interfaces;

public interface TicksInventory {

    void setTickDelay(int delay);

    void decrementTickDelay();

    int getTickDelay();
}
