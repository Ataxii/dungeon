package view;

import model.Move;
import model.Player;
import model.loot.Loot;
import model.monster.Monster;
import model.room.RoomType;

import java.awt.geom.Point2D;

public interface View {
    void handleMove(Move move);
    //la salle oùvous etes
    void room(RoomType roomType);

    // quand il y a un combat
    void fight(Player player, Monster monster);

    //quand il y a du loot
    void looting(Player player, Loot loot);

    //quand on propose d'utiliser une potion
    //...

}
