package model.room;


import model.Direction;
import model.Player;
import view.View;

import java.util.ArrayList;

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

    @Override
    public void action(Player player, ArrayList<View> views) {
    }
}
