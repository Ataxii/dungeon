package model.room;


import model.Direction;
import model.Fight;
import model.Player;
import model.monster.Monster;
import model.monster.Orc;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class MonsterRoom extends Room {
    private final Monster monster;

    public MonsterRoom(Direction... directions) {
        super(directions);
        this.monster = new Orc();
    }

    @Override
    public void action(Player player, ArrayList<View> views) {
        Fight.makeFight(player, monster, views);
    }

    @Override
    public String description() {
        return "salle avec un " + monster.getName();
    }

}
