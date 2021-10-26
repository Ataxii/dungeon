package model.room;

import com.sun.javafx.scene.traversal.Direction;

public class EmptyRoom implements RoomType{
    public Direction[] directions;

    public EmptyRoom(Direction[] directions) {
        this.directions = directions;
    }

    @Override
    public String description() {
        return "Vous êtes dans une salle avec rien";
    }

    @Override
    public Direction[] getDirections() {
        return directions;
    }
}
