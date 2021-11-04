package model;

import model.room.EmptyRoom;
import model.room.LootRoom;
import model.room.MonsterRoom;
import model.room.RoomType;
import view.ConsoleView;
import view.JavaFXView;
import view.View;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Dungeon {
    public Player player;
    public RoomType[][] rooms;
    public Point2D playerPosition;
    public ArrayList<View> views;


    public Dungeon() {
        this.player = new Player(10, 600);
        generation();
        playerPosition = new Point();
        playerPosition.setLocation(0,0);
        views = new ArrayList<>();
        views.add(new ConsoleView());
        views.add(new JavaFXView());
    }

    public void movePlayer(Direction direction){
        for (int i = 0; i < getActualRoom().getDirections().length; i++) {
            if (getActualRoom().getDirections()[i] == direction){
                //quand le player bouge on change playerPosition avec les 4 differents cas
                int playerX = (int) playerPosition.getX();
                int playerY = (int) playerPosition.getY();
                switch (direction) {
                    case UP:    playerPosition.setLocation(playerX, playerY - 1); break;
                    case DOWN:  playerPosition.setLocation(playerX, playerY + 1); break;
                    case LEFT:  playerPosition.setLocation(playerX - 1, playerY); break;
                    case RIGHT: playerPosition.setLocation(playerX + 1, playerY); break;
                }
                views.get(0).room(getActualRoom());
                getActualRoom().action(player, views);

                return;
            }
        }
    }

    public RoomType getActualRoom() {

        return rooms[(int) playerPosition.getX()][(int) playerPosition.getY()];
    }

    //construction du dongeon
//generation d'un patern deja fait

    /*  [.][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][ ][ ][ ]
        [ ][ ][ ][ ][ ][ ][.][ ][ ]
*/


    private void generation(){
        rooms = new RoomType[9][6];
        rooms[0][0] = new EmptyRoom(Direction.RIGHT);
        rooms[1][0] = new LootRoom(Direction.RIGHT, Direction.LEFT, Direction.DOWN);
        rooms[2][0] = new EmptyRoom(Direction.RIGHT, Direction.LEFT);
        rooms[3][0] = new EmptyRoom(Direction.RIGHT, Direction.LEFT);
        rooms[4][0] = new MonsterRoom(Direction.LEFT, Direction.DOWN);
        rooms[5][0] = new EmptyRoom(Direction.DOWN);
        rooms[1][1] = new EmptyRoom(Direction.DOWN, Direction.UP);
        rooms[1][2] = new LootRoom(Direction.RIGHT, Direction.UP);
        rooms[2][2] = new MonsterRoom(Direction.RIGHT, Direction.LEFT);
        rooms[3][2] = new EmptyRoom(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.UP);
        rooms[3][3] = new MonsterRoom(Direction.UP);
        rooms[4][2] = new MonsterRoom(Direction.LEFT);
        rooms[3][1] = new EmptyRoom(Direction.RIGHT, Direction.DOWN);
        rooms[4][1] = new MonsterRoom(Direction.RIGHT, Direction.LEFT, Direction.UP);
        rooms[5][1] = new EmptyRoom(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.UP);
        rooms[5][0] = new MonsterRoom(Direction.DOWN);
        rooms[5][2] = new EmptyRoom(Direction.DOWN, Direction.LEFT);
        rooms[6][2] = new EmptyRoom(Direction.DOWN, Direction.LEFT);
        rooms[6][3] = new EmptyRoom(Direction.DOWN, Direction.RIGHT, Direction.UP);
        rooms[6][4] = new EmptyRoom(Direction.DOWN, Direction.RIGHT, Direction.UP);
        rooms[6][5] = new MonsterRoom(Direction.UP);
        rooms[7][3] = new MonsterRoom(Direction.LEFT);
        rooms[7][4] = new MonsterRoom(Direction.LEFT);

    }
}



