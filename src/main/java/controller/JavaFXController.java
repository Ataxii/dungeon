package controller;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Dungeon;
import model.State.InventoryState;
import model.State.MoveState;
import model.State.State;

public class JavaFXController {

    //boolean inventory's = false;//on en aura plus besoin aprés
    private final Dungeon dungeon;
    EventHandler<? super KeyEvent> eventHandler;
    State moveState = new MoveState(this);
    State inventoryState = new InventoryState(this);
    State actualState = moveState;

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void changeState() {
        if (actualState.equals(moveState)) {
            this.actualState = inventoryState;
        } else this.actualState = moveState;

    }

    JavaFXController(Dungeon dungeon) {
        this.dungeon = dungeon;
        eventHandler = (EventHandler<KeyEvent>) event -> {

            switch (event.getCode()) {
                case UP:
                case Z:
                    actualState.playerMoveUp();
                    break;
                case DOWN:
                case S:
                    actualState.playerMoveDown();
                    break;
                case LEFT:
                case Q:
                    actualState.playerMoveLeft();
                    actualState.inventoryMoveLeft();
                    break;
                case RIGHT:
                case D:
                    actualState.playerMoveRight();
                    actualState.inventoryMoveRight();
                    break;
                //on rentre dans une phase de selection avec l'utilisateur
                case E:
                    actualState.openInventory();
                    actualState.closeInventory();
                    changeState();
                    break;
                case ENTER:
                    actualState.choosePotion();
            }
        };
    }
}
