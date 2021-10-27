package model.room;


import model.Direction;

public interface RoomType {
    public String description();
    public Direction[] getDirections();
}
