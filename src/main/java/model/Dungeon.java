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
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {
    public Player player;
    public RoomType[][] rooms;
    public Point2D playerPosition;
    public ArrayList<View> views;

    public Dungeon(JavaFXView view) {
        this.player = new Player(10, 600);
        generation();
        playerPosition = new Point();
        playerPosition.setLocation(0,0);
        views = new ArrayList<>();
        views.add(new ConsoleView());
        views.add(view);
    }

    public void movePlayer(Direction direction){
        for (int i = 0; i < getActualRoom().getDirections().length; i++) {
            if (getActualRoom().getDirections()[i] == direction){
                //quand le player bouge on change playerPosition avec les 4 differents cas
                int playerX = (int) playerPosition.getX();
                int playerY = (int) playerPosition.getY();
                //vu que le joueur est deja passé sur la room, on la set comme une empty room
                rooms[(int) playerPosition.getX()][(int) playerPosition.getY()] = new EmptyRoom(getActualRoom().getDirections());

                switch (direction) {
                    case UP:    playerPosition.setLocation(playerX, playerY - 1); break;
                    case DOWN:  playerPosition.setLocation(playerX, playerY + 1); break;
                    case LEFT:  playerPosition.setLocation(playerX - 1, playerY); break;
                    case RIGHT: playerPosition.setLocation(playerX + 1, playerY); break;
                }
                for (View view : views) {
                    view.makeSplit();
                    view.room(getActualRoom());
                }
                getActualRoom().action(player, views);
                return;
            }
        }
    }

    public void printInventory(){
        for (View view : views) {
            view.inventory(this);
        }
    }

    public RoomType getActualRoom() {
        return rooms[(int) playerPosition.getX()][(int) playerPosition.getY()];
    }


    /*
    Generation du donjon deja faites
     */
    private void generation(){
        rooms = new RoomType[9][6];
        rooms[0][0] = new EmptyRoom(Direction.RIGHT);
        rooms[1][0] = new LootRoom(Direction.RIGHT, Direction.LEFT, Direction.DOWN);
        rooms[2][0] = new EmptyRoom(Direction.RIGHT, Direction.LEFT);
        rooms[3][0] = new EmptyRoom(Direction.RIGHT, Direction.LEFT);
        rooms[4][0] = new MonsterRoom(Direction.LEFT, Direction.DOWN);
        rooms[1][1] = new EmptyRoom(Direction.DOWN, Direction.UP);
        rooms[1][2] = new LootRoom(Direction.RIGHT, Direction.UP);
        rooms[2][2] = new MonsterRoom(Direction.RIGHT, Direction.LEFT);
        rooms[3][2] = new EmptyRoom(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.UP);
        rooms[3][3] = new MonsterRoom(Direction.UP);
        rooms[4][2] = new MonsterRoom(Direction.LEFT, Direction.RIGHT);
        rooms[3][1] = new EmptyRoom(Direction.RIGHT, Direction.DOWN);
        rooms[4][1] = new MonsterRoom(Direction.RIGHT, Direction.LEFT, Direction.UP);
        rooms[5][1] = new EmptyRoom(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.UP);
        rooms[5][0] = new MonsterRoom(Direction.DOWN);
        rooms[5][2] = new EmptyRoom(Direction.DOWN, Direction.LEFT, Direction.UP, Direction.RIGHT);
        rooms[5][3] = new EmptyRoom(Direction.UP);
        rooms[6][1] = new LootRoom(Direction.LEFT);
        rooms[6][2] = new EmptyRoom(Direction.DOWN, Direction.LEFT);
        rooms[6][3] = new EmptyRoom(Direction.DOWN, Direction.RIGHT, Direction.UP);
        rooms[6][4] = new EmptyRoom(Direction.DOWN, Direction.RIGHT, Direction.UP);
        rooms[6][5] = new MonsterRoom(Direction.UP);
        rooms[7][3] = new MonsterRoom(Direction.LEFT);
        rooms[7][4] = new MonsterRoom(Direction.LEFT);
        rooms[4][5] = new MonsterRoom(Direction.UP);
        rooms[4][4] = new LootRoom(Direction.DOWN, Direction.LEFT);
        rooms[3][4] = new LootRoom(Direction.LEFT, Direction.RIGHT);
        rooms[2][4] = new LootRoom(Direction.DOWN,Direction.RIGHT);
        rooms[2][5] = new MonsterRoom(Direction.DOWN, Direction.UP, Direction.RIGHT);
        rooms[2][6] = new MonsterRoom(Direction.DOWN, Direction.LEFT, Direction.UP);
        rooms[2][7] = new MonsterRoom(Direction.UP);
        rooms[3][5] = new EmptyRoom(Direction.LEFT);
        rooms[1][6] = new EmptyRoom(Direction.RIGHT);
        rooms[5][3] = new LootRoom(Direction.LEFT);

    }


}



