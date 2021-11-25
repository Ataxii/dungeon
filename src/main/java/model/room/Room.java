package model.room;

import model.Direction;
import model.Player;
import view.View;

import java.util.ArrayList;

public abstract class Room {
    private final Direction[] directions;

    public Room(Direction... directions) {
        this.directions = directions;
    }

    public Direction[] getDirections(){
        return this.directions;
    }

    /**
     * provoque l'action liée à la room
     * @param player le joueur
     * @param views les views pour l'affichage
     */
    public abstract void action(Player player, ArrayList<View> views);
    public abstract String description();
}
