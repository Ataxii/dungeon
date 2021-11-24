package model.State;

import controller.JavaFXController;
import model.Direction;
import view.View;

public class InventoryState implements State{

    //on peut:
    //   -se deplacer dans l'inventaire
    //   -selectioner dans l'inventaire
    //   -quitter l'inventaire

    JavaFXController javaFXController;

    public InventoryState(JavaFXController javaFXController){
        this.javaFXController = javaFXController;
    }
    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {
        javaFXController.getDungeon().views.get(0).makeSplit();
        for (View view :
                javaFXController.getDungeon().views) {
            view.room(javaFXController.getDungeon().getActualRoom());
        }
    }

    @Override
    public void playerMoveRight() {

    }

    @Override
    public void playerMoveLeft() {

    }

    @Override
    public void playerMoveUp() {

    }

    @Override
    public void playerMoveDown() {

    }

    @Override
    public void inventoryMoveRight() {
        javaFXController.getDungeon().player.inventory.movePosition(Direction.DROITE);
        javaFXController.getDungeon().printInventory();
    }

    @Override
    public void inventoryMoveLeft() {
        javaFXController.getDungeon().player.inventory.movePosition(Direction.GAUCHE);
        javaFXController.getDungeon().printInventory();
    }


    @Override
    public void choosePotion() {
        javaFXController.getDungeon().player.takeHeal();
        javaFXController.getDungeon().player.inventory.resetPosition();
        javaFXController.getDungeon().printInventory();
    }
}
