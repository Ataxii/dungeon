package model.loot;

public class Potion implements Loot{
    private int value;


    @Override
    public String getName() {
        return "heal";
    }

    @Override
    public int getValue() {
        return 0;
    }
}
