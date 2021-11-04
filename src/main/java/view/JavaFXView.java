package view;

import javafx.scene.text.*;
import model.Move;
import model.Player;
import model.loot.Loot;
import model.monster.Monster;
import model.room.RoomType;

public class JavaFXView implements View{

    public Text text = new Text(100,100,"Bienvenue dans ce donjon. bonne chance pour cette aventure et en esperent que vous surviviez...");

    public void handleMove(Move move){
        text.setText(move.message);
    }

    @Override
    public void room(RoomType roomType) {

    }

    @Override
    public void fight(Player player, Monster monster) {

    }

    @Override
    public void looting(Player player, Loot loot) {

    }
}
