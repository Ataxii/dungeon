package model.room;


import com.sun.javafx.scene.traversal.Direction;
import model.loot.Loot;
import model.loot.Potion;
import model.loot.Weapon;

import java.util.Random;

public class LootRoom implements RoomType{
    private Loot loot;
    public Direction[] directions;

    public LootRoom(Direction[] directions) {
        this.loot = generationLoot();
        this.directions = directions;
    }

    private Loot generationLoot() {
        Random random = new Random();
        if(random.nextBoolean()){
            return new Weapon();
        }
        else return new Potion();
    }

    @Override
    public String description() {
        return "Vous êtes dans une salle avec du loot";
    }

    @Override
    public Direction[] getDirections() {
        return directions;
    }
}
