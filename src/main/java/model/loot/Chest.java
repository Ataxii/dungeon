package model.loot;

import java.util.Random;

public class Chest {
    private final Loot loot;

    public Chest() {
        this.loot = generationLoot();
    }

    public Loot getLoot() {
        return loot;
    }

    private Loot generationLoot() {
        Random random = new Random();
        if(random.nextBoolean()){
            return new Weapon();
        }
        else return new Potion();
    }
}
