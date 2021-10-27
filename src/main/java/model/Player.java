package model;

import com.sun.javafx.scene.traversal.Direction;
import view.ConsoleView;
import view.View;

import javax.swing.text.Position;

public class Player {
    public int strench;
    public int health;
    public Inventaire inventaire;

    /**
     * constructeur d'un playeur compsé d'un inventaire vide, une force et d'un nombre de hp
     * @param strench int pour la force
     * @param health int pour le nombre de hp
     */
    public Player(int strench, int health) {
        this.strench = strench;
        this.health = health;
        this.inventaire = new Inventaire(10);
    }

}
