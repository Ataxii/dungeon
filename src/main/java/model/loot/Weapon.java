package model.loot;

public class Weapon implements Loot{

    private int value;

    @Override
    public String getName() {
        return "weapon";
    }

    @Override
    public int getValue() {
        return 0;
    }
}
