package model.room;



import model.Direction;
import model.Player;
import model.loot.Chest;
import view.View;

import java.util.ArrayList;

public class LootRoom extends Room {
    private final Chest chest;

    public LootRoom(Direction... directions) {
        super(directions);
        this.chest = new Chest();
    }

    @Override
    public String description() {
        return "salle avec du loot";
    }

    @Override
    public void action(Player player, ArrayList<View> views) {
        chest.getLoot().action(player);
        for (View view : views) {
            view.looting(player, chest.getLoot());
        }
    }
}
