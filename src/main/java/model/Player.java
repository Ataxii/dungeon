package model;

import view.ConsoleView;
import view.View;

public class Player {
    public int strench;
    public int health;
    public Inventaire inventaire;

    public Player(int strench, int health) {
        this.strench = strench;
        this.health = health;
        this.inventaire = new Inventaire(10);
    }

    public Player() {

    }

    public Player(ConsoleView consoleView) {
    }
}
