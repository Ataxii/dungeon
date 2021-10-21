package model.room;

import model.Direction;

public class EmptyRoom implements RoomType{
    public Direction direction;

    @Override
    public String description() {
        return "Vous êtes dans une salle avec rien";
    }
}
