package model.room;


import model.Direction;
import model.Player;
import view.View;

import java.util.ArrayList;

public interface RoomType {
    public String description();
    public Direction[] getDirections();
    public void action(Player player, ArrayList<View> views);
}
