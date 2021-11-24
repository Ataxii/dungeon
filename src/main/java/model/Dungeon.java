package model;

import model.room.*;
import view.ConsoleView;
import view.JavaFXView;
import view.View;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Dungeon {
    private final Player player;
    public Room[][] rooms;
    public Point2D playerPosition;
    public ArrayList<View> views;

    public Dungeon(Player player, JavaFXView view, ConsoleView consoleView) {
        this.player = player;
        generation();
        playerPosition = new Point();
        playerPosition.setLocation(0,0);
        views = new ArrayList<>();
        views.add(consoleView);
        views.add(view);
    }

    /*
    Permet de faire bouger le joueur, d'actualiser les views et de faire l'action de la nouvelle room
     */
    public void movePlayer(Direction direction){
        for (int i = 0; i < getActualRoom().getDirections().length; i++) {
            if (getActualRoom().getDirections()[i] == direction){
                //quand le player bouge on change playerPosition avec les 4 differents cas
                int playerX = (int) playerPosition.getX();
                int playerY = (int) playerPosition.getY();
                //vu que le joueur est deja passé sur la room, on la set comme une empty room
                rooms[(int) playerPosition.getX()][(int) playerPosition.getY()] = new EmptyRoom(getActualRoom().getDirections());

                switch (direction) {
                    case HAUT:    playerPosition.setLocation(playerX, playerY - 1); break;
                    case BAS:  playerPosition.setLocation(playerX, playerY + 1); break;
                    case GAUCHE:  playerPosition.setLocation(playerX - 1, playerY); break;
                    case DROITE: playerPosition.setLocation(playerX + 1, playerY); break;
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

    public Room getActualRoom() {
        return rooms[(int) playerPosition.getX()][(int) playerPosition.getY()];
    }


    /*
    Generation du donjon deja faites
     */
    private void generation(){
        rooms = new Room[9][9];
        rooms[0][0] = new EmptyRoom(Direction.DROITE);
        rooms[1][0] = new LootRoom(Direction.DROITE, Direction.GAUCHE, Direction.BAS);
        rooms[2][0] = new EmptyRoom(Direction.DROITE, Direction.GAUCHE);
        rooms[3][0] = new EmptyRoom(Direction.DROITE, Direction.GAUCHE);
        rooms[4][0] = new MonsterRoom(Direction.GAUCHE, Direction.BAS);
        rooms[1][1] = new EmptyRoom(Direction.BAS, Direction.HAUT);
        rooms[1][2] = new LootRoom(Direction.DROITE, Direction.HAUT);
        rooms[2][2] = new MonsterRoom(Direction.DROITE, Direction.GAUCHE);
        rooms[3][2] = new EmptyRoom(Direction.DROITE, Direction.GAUCHE, Direction.BAS, Direction.HAUT);
        rooms[3][3] = new MonsterRoom(Direction.HAUT, Direction.BAS);
        rooms[4][2] = new MonsterRoom(Direction.GAUCHE, Direction.DROITE);
        rooms[3][1] = new EmptyRoom(Direction.DROITE, Direction.BAS);
        rooms[4][1] = new MonsterRoom(Direction.DROITE, Direction.GAUCHE, Direction.HAUT);
        rooms[5][1] = new EmptyRoom(Direction.DROITE, Direction.GAUCHE, Direction.BAS, Direction.HAUT);
        rooms[5][0] = new MonsterRoom(Direction.BAS);
        rooms[5][2] = new EmptyRoom(Direction.BAS, Direction.GAUCHE, Direction.HAUT, Direction.DROITE);
        rooms[5][3] = new EmptyRoom(Direction.HAUT);
        rooms[6][1] = new LootRoom(Direction.GAUCHE);
        rooms[6][2] = new EmptyRoom(Direction.BAS, Direction.GAUCHE);
        rooms[6][3] = new EmptyRoom(Direction.BAS, Direction.DROITE, Direction.HAUT);
        rooms[6][4] = new EmptyRoom(Direction.BAS, Direction.DROITE, Direction.HAUT);
        rooms[6][5] = new MonsterRoom(Direction.HAUT);
        rooms[7][3] = new MonsterRoom(Direction.GAUCHE);
        rooms[7][4] = new MonsterRoom(Direction.GAUCHE);
        rooms[4][5] = new MonsterRoom(Direction.HAUT);
        rooms[4][4] = new LootRoom(Direction.BAS, Direction.GAUCHE);
        rooms[3][4] = new LootRoom(Direction.GAUCHE, Direction.DROITE);
        rooms[2][4] = new LootRoom(Direction.BAS,Direction.DROITE);
        rooms[2][5] = new MonsterRoom(Direction.BAS, Direction.HAUT, Direction.DROITE);
        rooms[2][6] = new MonsterRoom(Direction.BAS, Direction.GAUCHE, Direction.HAUT);
        rooms[2][7] = new MonsterRoom(Direction.HAUT);
        rooms[3][5] = new EmptyRoom(Direction.GAUCHE);
        rooms[1][6] = new EmptyRoom(Direction.DROITE);
        rooms[5][3] = new LootRoom(Direction.HAUT);
    }

    public Player getPlayer() {
        return player;
    }
}



