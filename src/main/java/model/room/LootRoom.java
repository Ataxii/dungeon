package model.room;



import model.Direction;
import model.Player;
import model.loot.Chess;
import model.loot.Loot;
import model.loot.Potion;
import model.loot.Weapon;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class LootRoom extends Room {
    private final Chess chess;

    public LootRoom(Direction... directions) {
        super(directions);
        chess = new Chess();
    }

    @Override
    public String description() {
        return "salle avec du loot";
    }

    @Override
    public void action(Player player, ArrayList<View> views) {
        chess.getLoot().action(player);
        for (View view : views) {
            view.looting(player, chess.getLoot());
        }
    }
}
