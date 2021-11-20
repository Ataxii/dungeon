package model;

import model.loot.Loot;

public class Player {
    public int strength;
    public int health;
    private int maxHealth;
    public Inventory inventory;

    /**
     * constructeur d'un playeur compsé d'un inventaire vide, une force et d'un nombre de hp
     * @param strength int pour la force
     * @param health int pour le nombre de hp
     */
    public Player(int strength, int health) {
        this.strength = strength;
        this.health = health;
        this.maxHealth = health;
        this.inventory = new Inventory(10);
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void takeDammage(int dammage){
        health = health - dammage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void takeHeal(){

        Loot potion = inventory.use();
        if (health + potion.getValue() > maxHealth){
            health = maxHealth;
        }
        else {
            health = health + potion.getValue();
        }
    }

}
