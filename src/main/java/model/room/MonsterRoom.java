package model.room;


import model.Direction;
import model.monster.Monster;
import model.monster.Orc;

public class MonsterRoom implements RoomType{
    private Monster monster;
    private final Direction[] directions;

    public MonsterRoom(Direction... directions) {
        this.monster = new Orc(100, 13);
        this.directions = directions;
    }

    public Monster getMonster() {
        return monster;
    }

    public void killMonster(){
        monster = null;
    }

    public boolean isDead(){
        return monster == null;
    }

    public Direction[] getDirections() {
        return directions;
    }

    @Override
    public String description() {
        return "MonsterRoom avec un " + monster.getName();
    }

}
