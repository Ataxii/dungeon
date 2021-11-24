package model.loot;

import model.Player;

import java.util.Random;

public class Weapon implements Loot{
    Random rand = new Random();
    int value = rand.nextInt(20 - 10 + 1) + 10;


    @Override
    public String getName() {
        return "arme";
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void action(Player player) {
        player.setStrength(player.getStrength()+getValue());
    }
}
