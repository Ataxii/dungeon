package model.loot;

import model.Player;

import java.util.Random;

public class Potion implements Loot{
    Random rand = new Random();
    int value = rand.nextInt(80 - 40 + 1) + 40;

    @Override
    public String getName() {
        return "Potion de vie";
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void action(Player player) {
        player.inventory.addLoot(this);
    }
}
