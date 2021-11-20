package model.monster;

public interface Monster {
    public int getHp();
    public int getStrength();
    public String getName();
    public boolean isAlive();
    public void takeDammage(int dammage);
    int getLife();
}
