package view;

import model.Direction;
import model.Dungeon;
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
        dialogue += "Tu es actuellement dans une " + roomType.description() + ", tu peux aller :\n";
        for (Direction direction:
             roomType.getDirections()) {
            dialogue += "   -" + direction.name() + "\n";
        }
        System.out.println(dialogue);
    }

    @Override
    public void fight(Player player, Monster monster) {
        System.out.println("Le monstre que vous allez combatre a " + monster.getStrength() +
                " de force et " + monster.getHp() + " de vie");

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
        System.out.println("Vous avez récupéré : " + loot.getName() + " avec une value de : " + loot.getValue());
        System.out.println("Votre personnage a une vie de : " + player.health + " et une force de : " + player.strength);
    }

    @Override
    public void makeSplit() {
        System.out.println("--------------------------\n\n");
    }

    @Override
    public void inventory(Dungeon dungeon) {

        String selection = "";
        int i = 0;
        if(dungeon.player.inventory.isEmpty()){
            System.out.println("Ton inventaire est vide!");
            System.out.println("[e] pour sortir");
        }
        else {
            for (Loot loot : dungeon.player.inventory.getLoots()) {

                if(dungeon.player.inventory.getPosition() == i){
                    selection += "{" + i + "}" + " : " + loot.getName() + " de " + loot.getValue() + " hp || ";
                }
                else {
                    selection += i + " : " + loot.getName() + " de " + loot.getValue() + " hp";
                }

                i ++;
            }
            System.out.println(selection);
        }


    }






}
