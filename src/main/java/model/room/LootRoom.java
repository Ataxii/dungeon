package model.room;



import model.Direction;
import model.loot.Loot;
import model.loot.Potion;
import model.loot.Weapon;

import java.util.Random;

public class LootRoom implements RoomType{
    private final Loot loot;
    public Direction[] directions;

    public LootRoom(Direction... directions) {
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

    public Loot getLoot() {
        return loot;
    }

    @Override
    public String description() {
        return "lootRoom";
    }

    @Override
    public Direction[] getDirections() {
        return directions;
    }
}
