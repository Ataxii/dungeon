package model;

import model.loot.Loot;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Loot> loots;

    private int capacity;
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

    public boolean addLoot(Loot loot){
        if(isFull()){
            return false;
        }
        else {
            loots.add(loot);
            return true;
        }
    }

    public ArrayList<Loot> getLoots() {
        return loots;
    }

    private boolean remove(Loot loot){
        if (isEmpty()){
            return false;
        }else {
            loots.remove(loot);
            return true;
        }
    }

    public void movePosition(Direction direction) {
        switch (direction){
            case LEFT : if(position != 0){ position--;}; break;
            case RIGHT: if(position != getSize() - 1){position++;}; break;
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
