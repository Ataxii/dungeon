package model.room;


import model.Direction;
import model.Player;
import model.monster.Monster;
import model.monster.Orc;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class MonsterRoom implements RoomType {
    private Monster monster;
    private final Direction[] directions;

    public MonsterRoom(Direction... directions) {
        this.monster = new Orc(100, 13);
        this.directions = directions;
    }

    public Monster getMonster() {
        return monster;
    }

    public void killMonster() {
        monster = null;
    }

    public boolean isFighted() {
        return monster == null;
    }

    public Direction[] getDirections() {
        return directions;
    }

    @Override
    public void action(Player player, ArrayList<View> views) {
        while (player.isAlive() && monster.isAlive()) {
            if (player.strench > monster.getStrength()) {
                monster.takeDammage(player.strench);
                //a une chance d'attaquer
                Random random = new Random();
                if (random.nextBoolean()) {
                    player.takeDammage(monster.getStrength());
                }
            } else {
                Random random = new Random();
                if (random.nextBoolean()) {
                    player.takeDammage(monster.getStrength());
                }
                monster.takeDammage(player.strench);
            }
        }
        //récompense si le montre etait plus fort
        if (monster.getStrength() > player.strench){
            player.strench = player.strench + (monster.getStrength() - player.strench);
        }
        for (View view : views) {
            view.fight(player, monster);
        }
    }

    @Override
    public String description() {
        return "MonsterRoom avec un " + monster.getName();
    }

}
