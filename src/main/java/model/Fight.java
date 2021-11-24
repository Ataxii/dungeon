package model;

import model.monster.Monster;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class Fight {

    public static void makeFight(Player player, Monster monster, ArrayList<View> views){
        while (player.isAlive() && monster.isAlive()) {
            if (player.getStrength() > monster.getStrength()) {
                monster.takeDammage(player.getStrength());
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
                monster.takeDammage(player.getStrength());
            }
        }
        //récompense si le monstre était plus fort
        if (monster.getStrength() > player.getStrength()){
            player.setStrength(player.getStrength() + (monster.getStrength() - player.getStrength()));
        }
        for (View view : views) {
            view.fight(player, monster);
        }
    }
}
