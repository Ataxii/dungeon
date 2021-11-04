package model;

public class Player {
    public int strench;
    public int health;
    public Inventory inventaire;

    /**
     * constructeur d'un playeur compsé d'un inventaire vide, une force et d'un nombre de hp
     * @param strench int pour la force
     * @param health int pour le nombre de hp
     */
    public Player(int strench, int health) {
        this.strench = strench;
        this.health = health;
        this.inventaire = new Inventory(10);
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void takeDammage(int dammage){
        health = health - dammage;
    }

}
