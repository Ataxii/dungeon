package model.room;

import com.sun.javafx.scene.traversal.Direction;

public interface RoomType {
    public String description();
    public Direction[] getDirections();
}
