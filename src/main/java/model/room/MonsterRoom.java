package model.room;

import model.monster.Monster;

public class MonsterRoom implements RoomType{
    private Monster monster;

    @Override
    public String description() {
        return "Vous êtes dans une salle avec un monstre";
    }
}
