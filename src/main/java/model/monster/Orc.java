package model.monster;

import java.util.Random;

public class Orc implements Monster{
    private int hp;
    private int life;
    private final int strength;

    public Orc(int hp, int strength) {
        this.hp = hp;
        this.strength = strength;
        this.life = hp;
    }

    //génération aléatoir
    public Orc(){
        Random rand = new Random();
        int hp = rand.nextInt(170 - 100 + 1) + 100;
        this.hp = hp;
        this.life = hp;
        this.strength = rand.nextInt(25 - 5 + 1) + 5;

    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public String getName() {
        return "Orc";
    }

    @Override
    public boolean isAlive(){
        return getHp() > 0;
    }

    @Override
    public void takeDammage(int dammage) {
        hp = hp - dammage;
    }

    @Override
    public int getLife() {
        return life;
    }


}
