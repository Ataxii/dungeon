package model.room;



import model.Direction;
import model.Player;
import model.loot.WoodChest;
import view.View;

import java.util.ArrayList;

public class LootRoom extends Room {
    private final WoodChest woodChest;

    public LootRoom(Direction... directions) {
        super(directions);
        this.woodChest = new WoodChest();
    }

    @Override
    public String description() {
        return "salle avec du loot";
    }

    @Override
    public void action(Player player, ArrayList<View> views) {
        woodChest.getLoot().action(player);
        for (View view : views) {
            view.looting(player, woodChest.getLoot());
        }
    }
}
