package model.loot;

import model.Player;

public interface Loot {

    String getName();
    int getValue();
    void action(Player player);

}
