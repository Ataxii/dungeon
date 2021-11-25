package model;

import model.monster.Monster;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class Fight implements IFight {

    /*
    Le monstre attaque en premier
     */
    public static void makeFightMonsterFirst(Player player, Monster monster, ArrayList<View> views){
        while (player.isAlive() && monster.isAlive()) {

            player.takeDamages(monster.getStrength());
            monster.takeDammage(player.getStrength());

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
