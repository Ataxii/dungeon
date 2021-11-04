package view;

import model.Move;
import model.Player;
import model.loot.Loot;
import model.monster.Monster;
import model.room.RoomType;

public class ConsoleView implements View {

    @Override
    public void handleMove(Move move){
        System.out.println(move.message);
    }

    @Override
    public void room(RoomType roomType) {
        String dialogue = "";
        dialogue += "tu es actuellement dans une " + roomType.description();
        System.out.println(dialogue);
    }

    @Override
    public void fight(Player player, Monster monster) {
        System.out.println("le monstre que vous allez combatre a " + monster.getStrength() +
                "de force et " + monster.getHp() + " de vie");

        if (monster.isAlive()){
            System.out.println("Vous avez malheureusement perdu le combat :(");
        }
        else {
            System.out.println("Vous avez gagné le combat !!! Vous avez donc " + player.health + " de vie et "
            + player.strength + " de force");
        }
    }

    @Override
    public void looting(Player player, Loot loot) {
        System.out.println("Vous avez récupéré : " + loot.getName() + "avec une value de : " + loot.getValue());
        System.out.println("Votre personnage a donc une vie de : " + player.health + " et une force de : " + player.strength);
    }


}
