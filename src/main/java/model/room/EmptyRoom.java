package model.room;


import model.Direction;
import model.Player;
import view.View;

import java.util.ArrayList;

public class EmptyRoom extends Room {

    public EmptyRoom(Direction... directions) {
        super(directions);
    }

    @Override
    public String description() {
        return "salle vide";
    }

    @Override
    public void action(Player player, ArrayList<View> views) {
        views.get(1).makeSplit();
    }
}
