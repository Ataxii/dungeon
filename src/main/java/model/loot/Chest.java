package model.loot;

public abstract class Chest {
    Loot loot;

    public Chest() {
        this.loot = generationLoot();
    }

    public Loot getLoot() {
        return loot;
    }

    public abstract Loot generationLoot();
}
