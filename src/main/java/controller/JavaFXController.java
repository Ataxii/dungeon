package controller;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Direction;
import model.Dungeon;

public class JavaFXController {

    boolean inventoryphase = false;
    EventHandler<? super KeyEvent> eventHandler;

    JavaFXController(Dungeon dungeon){

     eventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if (!inventoryphase) {
                switch (event.getCode()) {

                    case UP:    dungeon.movePlayer(Direction.UP); break;
                    case DOWN:  dungeon.movePlayer(Direction.DOWN); break;
                    case LEFT:  dungeon.movePlayer(Direction.LEFT); break;
                    case RIGHT: dungeon.movePlayer(Direction.RIGHT); break;

                    case A:  dungeon.movePlayer(Direction.UP); break;
                    case S:  dungeon.movePlayer(Direction.DOWN); break;
                    case Q:  dungeon.movePlayer(Direction.LEFT); break;
                    case D:  dungeon.movePlayer(Direction.RIGHT); break;

                    //on rentre dans une phase de selection avec l'utilisateur
                    case E: inventoryphase = true;dungeon.printInventory(); break;
                }

            }
            else {
                switch (event.getCode()) {
                    case LEFT:

                    case Q:
                        dungeon.player.inventory.movePosition(Direction.LEFT); dungeon.printInventory(); break;
                    case RIGHT:
                    case D:
                        dungeon.player.inventory.movePosition(Direction.RIGHT); dungeon.printInventory(); break;

                    case ENTER: dungeon.player.takeHeal(); dungeon.printInventory(); break;

                    //on sort de la phase de selection avec l'utilisateur
                    case E: inventoryphase = false; break;
                }
            }
        }

    };}

}
