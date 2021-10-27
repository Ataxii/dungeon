package controller;


import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import model.Direction;
import model.Dungeon;
import model.Player;

public class JavaFXController {
    EventHandler<? super KeyEvent> eventHandler;

    JavaFXController(Dungeon dungeon){

     eventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case UP:    dungeon.movePlayer(Direction.UP); break;
                case DOWN:  dungeon.movePlayer(Direction.DOWN); break;
                case LEFT:  dungeon.movePlayer(Direction.LEFT); break;
                case RIGHT: dungeon.movePlayer(Direction.RIGHT); break;
            }
        }

    };}

}
