package view;

import javafx.scene.text.*;
import model.Move;

public class JavaFXView implements View{

    public Text text = new Text(100,100,"Bienvenue dans ce donjon. bonne chance pour cette aventure et en esperent que vous surviviez...");

    public void handleMove(Move move){
        text.setText(move.message);
    }
}
