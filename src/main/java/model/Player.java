package model;

import model.loot.Loot;

public class Player {
    private int strength;
    private int health;
    private final int maxHealth;
    private final Inventory inventory;

    /**
     * Constructeur d'un player composé d'un inventaire vide, une force et d'un nombre de hp
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

    public void takeDamages(int damages){
        health = health - damages;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void takeHeal(){
        Loot potion = inventory.use();
        health = Math.min(health + potion.getValue(), maxHealth);
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
