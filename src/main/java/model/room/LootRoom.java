package model.room;



import model.Direction;
import model.Player;
import model.loot.Loot;
import model.loot.Potion;
import model.loot.Weapon;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class LootRoom extends Room {
    private final Loot loot;

    public LootRoom(Direction... directions) {
        super(directions);
        this.loot = generationLoot();
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
        return "salle avec du loot";
    }


    @Override
    public void action(Player player, ArrayList<View> views) {
        loot.action(player);
        for (View view : views) {
            view.looting(player, loot);
        }
    }
}
