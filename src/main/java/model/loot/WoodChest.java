package model.loot;

import java.util.Random;

public class WoodChest extends Chest{

    /**
     * Génère le loot pour le coffre de manière aléatoire
     * @return le loot généré
     */
    public Loot generationLoot() {
        Random random = new Random();
        if(random.nextBoolean()){
            return new Weapon();
        }
        else return new Potion();
    }
}
