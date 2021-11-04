package model.loot;

import model.Player;

public class Weapon implements Loot{

    private int value;

    @Override
    public String getName() {
        return "weapon";
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void action(Player player) {
        player.strench += getValue();
    }
}
