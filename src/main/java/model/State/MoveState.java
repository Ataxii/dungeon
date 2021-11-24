package model.State;

import controller.JavaFXController;
import model.Direction;

public class MoveState implements State{

    //on peut :
    //   -se deplacer
    //   -ouvrir l'inventaire
    JavaFXController javaFXController;

    public MoveState(JavaFXController javaFXController){
        this.javaFXController = javaFXController;
    }


    @Override
    public void openInventory() {
        javaFXController.getDungeon().printInventory();
    }

    @Override
    public void closeInventory() {

    }

    @Override
    public void playerMoveRight() {
        javaFXController.getDungeon().movePlayer(Direction.DROITE);

    }

    @Override
    public void playerMoveLeft() {
        javaFXController.getDungeon().movePlayer(Direction.GAUCHE);

    }

    @Override
    public void playerMoveUp() {
        javaFXController.getDungeon().movePlayer(Direction.HAUT);
    }

    @Override
    public void playerMoveDown() {
        javaFXController.getDungeon().movePlayer(Direction.BAS);

    }

    @Override
    public void inventoryMoveRight() {

    }

    @Override
    public void inventoryMoveLeft() {

    }


    @Override
    public void choosePotion() {

    }
}
