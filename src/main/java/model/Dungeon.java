package model;

import model.room.RoomType;

import java.awt.*;
import java.awt.geom.Point2D;

public class Dungeon {
    public Player player;
    public RoomType[][] rooms;
    public Point2D playerPosition;


    public Dungeon() {
        this.player = new Player();
        generation();
        playerPosition = new Point();
        playerPosition.setLocation(0,0);

    }

    public RoomType getActualRoom() {
        return rooms[(int) playerPosition.getX()][(int) playerPosition.getY()];
    }

    //construction du dongeon
//generation d'un patern deja fait


/*

        [.][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][.][ ][ ]
*/

    private void generation(){

    }
}



