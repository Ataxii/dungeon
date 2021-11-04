package model.monster;

public class Orc implements Monster{
    private int hp;
    private int strength;

    public Orc(int hp, int strength) {
        this.hp = hp;
        this.strength = strength;
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


}
