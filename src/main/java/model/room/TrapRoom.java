package model.room;

import model.Direction;
import model.Player;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class TrapRoom extends Room{
    int damage;

    public TrapRoom(Direction... directions) {
        super(directions);
        Random random = new Random();
        this.damage = random.nextInt(170 - 100 + 1) + 100;
    }

    @Override
    public void action(Player player, ArrayList<View> views) {
        player.takeDamages(damage);
        for (View view:
             views) {
            view.makeSplit(player);
        }
    }

    @Override
    public String description() {
        return "salle avec un piège qui vous inflige " + damage + "de dégat";
    }
}
