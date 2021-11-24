package controller;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Direction;
import model.Dungeon;
import model.State.InventoryState;
import model.State.MoveState;
import model.State.State;
import view.View;

public class JavaFXController {

    //boolean inventoryphase = false;//on en aura plus besoin aprés
    private final Dungeon dungeon;
    EventHandler<? super KeyEvent> eventHandler;
    State moveState = new MoveState(this);
    State inventoryState = new InventoryState(this);
    State actualState = moveState;

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void changeState() {
        if (actualState.equals(moveState)){
            this.actualState = inventoryState;
        }
        else this.actualState = moveState;

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



    /*
    JavaFXController(Dungeon dungeon) {
        this.dungeon = dungeon;
        eventHandler = (EventHandler<KeyEvent>) event -> {
            if (!inventoryphase) {
                switch (event.getCode()) {

                    case UP:
                    case A:
                        dungeon.movePlayer(Direction.HAUT);
                        break;
                    case DOWN:
                    case S:
                        dungeon.movePlayer(Direction.BAS);
                        break;
                    case LEFT:
                    case Q:
                        dungeon.movePlayer(Direction.GAUCHE);
                        break;
                    case RIGHT:
                    case D:
                        dungeon.movePlayer(Direction.DROITE);
                        break;

                    //on rentre dans une phase de selection avec l'utilisateur
                    case E:
                        inventoryphase = true;
                        dungeon.printInventory();
                        break;
                }

            } else {
                switch (event.getCode()) {
                    case LEFT:
                    case Q:
                        dungeon.player.inventory.movePosition(Direction.GAUCHE);
                        dungeon.printInventory();
                        break;
                    case RIGHT:
                    case D:
                        dungeon.player.inventory.movePosition(Direction.DROITE);
                        dungeon.printInventory();
                        break;

                    case ENTER:
                        dungeon.player.takeHeal();
                        dungeon.player.inventory.resetPosition();
                        dungeon.printInventory();
                        break;

                    //on sort de la phase de selection avec l'utilisateur
                    case E:
                        inventoryphase = false;
                        dungeon.views.get(0).makeSplit();
                        for (View view :
                                dungeon.views) {
                            view.room(dungeon.getActualRoom());
                        }
                        break;
                }
            }
        };
    }*/


}
