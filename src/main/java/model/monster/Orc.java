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
        return 0;
    }

    @Override
    public int getStrength() {
        return 0;
    }

    @Override
    public String getName() {
        return "Orc";
    }
}
