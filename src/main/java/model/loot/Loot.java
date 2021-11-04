package model.loot;

import model.Player;

public interface Loot {

    public String getName();
    public int getValue();
    public void action(Player player);

}
