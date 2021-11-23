package model;

import model.loot.Loot;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Loot> loots;

    private final int capacity;
    private int position; //position du curseur de selection

    public Inventory(int capacity) {
        this.loots = new ArrayList<>();
        this.capacity = capacity;
        this.position = 0;
    }

    public int getSize() {
        return loots.size();
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public boolean isFull(){
        return getSize() == capacity;
    }

    public void addLoot(Loot loot){
        if(!isFull()){
            loots.add(loot);
        }
    }

    public ArrayList<Loot> getLoots() {
        return loots;
    }

    private void remove(Loot loot){
        if (!isEmpty()){
            loots.remove(loot);
        }
    }

    public void movePosition(Direction direction) {
        switch (direction){
            case GAUCHE: if(position != 0){ position--;} break;
            case DROITE: if(position != getSize() - 1){position++;} break;
        }

    }

    public int getPosition() {
        return position;
    }

    public Loot use(){
        Loot lootResult = loots.get(position);
        remove(lootResult);
        return lootResult;
    }

    public void resetPosition() {
        position = 0;
    }
}
