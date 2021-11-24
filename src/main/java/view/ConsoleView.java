package view;

import model.Direction;
import model.Dungeon;
import model.Player;
import model.loot.Loot;
import model.monster.Monster;
import model.room.Room;


public class ConsoleView implements View {


    @Override
    public void room(Room roomType) {
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
                " de force et " + monster.getLife() + " de vie");

        if (monster.isAlive()){
            System.out.println("Vous avez malheureusement perdu le combat :(");
        }
        else {
            System.out.println("Vous avez gagné le combat !!! Vous avez donc " + player.getHealth() + " de vie et "
            + player.getStrength() + " de force");
        }
    }

    @Override
    public void looting(Player player, Loot loot) {
        System.out.println("Vous avez récupéré : " + loot.getName() + " avec une value de : " + loot.getValue());
        System.out.println("Votre personnage a une vie de : " + player.getHealth() + " et une force de : " + player.getStrength());
    }

    @Override
    public void makeSplit(){
        System.out.println("--------------------------\n\n\n\n\n\n\n\n\n\n");

    }

    @Override
    public void inventory(Dungeon dungeon) {
        makeSplit();
        String selection = "";
        int i = 0;
        if(dungeon.getPlayer().getInventory().isEmpty()){
            System.out.println("Ton inventaire est vide!");
        }
        else {
            System.out.println("Tu as " + dungeon.getPlayer().getHealth() + "/" + dungeon.getPlayer().getMaxHealth() + " hp");
            for (Loot loot : dungeon.getPlayer().getInventory().getLoots()) {

                if(dungeon.getPlayer().getInventory().getPosition() == i){
                    selection += "{" + i + "}" + " : " + loot.getName() + " de " + loot.getValue() + " hp || ";
                }
                else {
                    selection += i + " : " + loot.getName() + " de " + loot.getValue() + " hp || ";
                }
                i ++;
            }
            System.out.println(selection);
        }
        System.out.println("[e] pour sortir");
    }
}
