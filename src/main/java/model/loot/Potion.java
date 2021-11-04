package model.loot;

import model.Player;

public class Potion implements Loot{
    private int value;


    @Override
    public String getName() {
        return "heal";
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void action(Player player) {
        player.inventaire.addLoot(this);
    }
}
