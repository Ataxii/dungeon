package view;

import model.Dungeon;
import model.Player;
import model.loot.Loot;
import model.monster.Monster;
import model.room.Room;

public interface View {
    //la salle oùvous etes
    void room(Room roomType);

    // quand il y a un combat
    void fight(Player player, Monster monster);

    //quand il y a du loot
    void looting(Player player, Loot loot);

    //quand on propose d'utiliser une potion
    //...

    void makeSplit();

    void inventory(Dungeon dungeon);
}
