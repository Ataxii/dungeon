package model;

import model.loot.Loot;

public class Inventory {
    private Loot[] loots;
    private int size;
    private int capacity;

    public Inventory(int capacity) {
        this.loots = new Loot[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
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
            loots[size] = loot;
            size++;
            return true;
        }
    }

    public boolean remove(Loot loot){
        if (isEmpty()){
            return false;
        }else {
            loots[size-1] = null;
            size--;
            return true;
        }
    }
}
