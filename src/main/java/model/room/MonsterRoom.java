package model.room;


import model.Direction;
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
        while (player.isAlive() && monster.isAlive()) {
            if (player.strength > monster.getStrength()) {
                monster.takeDammage(player.strength);
                //a une chance d'attaquer
                Random random = new Random();
                if (random.nextBoolean()) {
                    player.takeDamages(monster.getStrength());
                }
            } else {
                Random random = new Random();
                if (random.nextBoolean()) {
                    player.takeDamages(monster.getStrength());
                }
                monster.takeDammage(player.strength);
            }
        }
        //récompense si le montre etait plus fort
        if (monster.getStrength() > player.strength){
            player.strength = player.strength + (monster.getStrength() - player.strength);
        }
        for (View view : views) {
            view.fight(player, monster);
        }
    }

    @Override
    public String description() {
        return "salle avec un " + monster.getName();
    }

}
