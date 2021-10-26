package model.room;

import com.sun.javafx.scene.traversal.Direction;
import model.monster.Monster;
import model.monster.Orc;

public class MonsterRoom implements RoomType{
    private Monster monster;
    private Direction[] directions;

    public MonsterRoom(Direction[] directions) {
        this.monster = new Orc(100, 13);
        this.directions = directions;
    }

    public Monster getMonster() {
        return monster;
    }

    public Direction[] getDirections() {
        return directions;
    }

    @Override
    public String description() {
        return "Vous êtes dans une salle avec un monstre";
    }

}
