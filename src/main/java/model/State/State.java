package model.State;

public interface State {
    void openInventory();
    void closeInventory();
    void playerMoveRight();
    void playerMoveLeft();
    void playerMoveUp();
    void playerMoveDown();
    void inventoryMoveRight();
    void inventoryMoveLeft();
    void choosePotion();

}
