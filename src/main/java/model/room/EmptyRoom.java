package model.room;


import model.Direction;

public class EmptyRoom implements RoomType{
    public Direction[] directions;

    public EmptyRoom(Direction... directions) {
        this.directions = directions;
    }

    @Override
    public String description() {
        return "EmptyRoom";
    }

    @Override
    public Direction[] getDirections() {
        return directions;
    }
}
