package model.room;

import model.Direction;
import model.loot.Loot;

public class LootRoom implements RoomType{
    private Loot loot;
    public Direction direction;

    @Override
    public String description() {
        return "Vous êtes dans une salle avec du loot";
    }
}
