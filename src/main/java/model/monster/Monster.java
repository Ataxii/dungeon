package model.monster;

public interface Monster {
    int getHp();
     int getStrength();
     String getName();
     boolean isAlive();
    void takeDammage(int dammage);
    int getLife();
}
