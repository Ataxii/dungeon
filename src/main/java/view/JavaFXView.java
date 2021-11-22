package view;

import javafx.scene.text.*;
import model.Direction;
import model.Dungeon;
import model.Move;
import model.Player;
import model.loot.Loot;
import model.monster.Monster;
import model.room.RoomType;

public class JavaFXView implements View{


    public Text playerInformation = new Text(300, 20, "");
    public Text top = new Text(100,100,"Bienvenue dans ce donjon.\n bonne chance pour cette aventure et en esperent que vous surviviez...");
    public Text middle = new Text(100, 200, "");
    public Text inventaire = new Text(100 , 300, "[e] ouvir l'inventaire");

    public void updatePlayer(Player player){
        playerInformation.setText("Player : " + player.health + "/" + player.getMaxHealth() + " hp");

    }

    public void handleMove(Move move){
        top.setText(move.message);
    }

    @Override
    public void room(RoomType roomType) {
        String dialogue = "";
        dialogue += "Tu es actuellement dans une " + roomType.description() + ", tu peux aller :\n";
        for (Direction direction:
                roomType.getDirections()) {
            dialogue += "   -" + direction.name() + "\n";
        }
        this.top.setText(dialogue);
        inventaire.setText("[e] ouvir l'inventaire");

    }

    @Override
    public void fight(Player player, Monster monster) {
        String dialogue = "";
        dialogue += "Le monstre que vous allez combatre a " + monster.getStrength() +
                " de force et " + monster.getLife() + " de vie\n";

        if (monster.isAlive()){
            dialogue += "Vous avez malheureusement perdu le combat :(\n";
        }
        else {
            dialogue += "Vous avez gagné le combat !!! Vous avez donc " + player.health + " de vie et "
                    + player.strength + " de force\n";
        }
        this.middle.setText(dialogue);
        updatePlayer(player);
    }

    @Override
    public void looting(Player player, Loot loot) {
        String dialogue = "";
        dialogue += "Vous avez récupéré : " + loot.getName() + " avec une value de : " + loot.getValue() + "\n";
        dialogue += "Votre personnage a une vie de : " + player.health + " et une force de : " + player.strength + "\n";
        this.middle.setText(dialogue);
    }

    @Override
    public void makeSplit() {
        this.middle.setText("");
    }

    @Override
    public void inventory(Dungeon dungeon) {
        makeSplit();
        String selection = "";
        String dialoque = "";
        int i = 0;
        if(dungeon.player.inventory.isEmpty()){
            dialoque += "Ton inventaire est vide!";
        }
        else {
            dialoque+= "Tu as " + dungeon.player.health + "/" + dungeon.player.getMaxHealth() + " hp\n";
            for (Loot loot : dungeon.player.inventory.getLoots()) {

                if(dungeon.player.inventory.getPosition() == i){
                    selection += "{" + i + "}" + " : " + loot.getName() + " de " + loot.getValue() + " hp || ";
                }
                else {
                    selection += i + " : " + loot.getName() + " de " + loot.getValue() + " hp || ";
                }
                i ++;
            }
            dialoque += selection;
        }

        top.setText(dialoque);
        inventaire.setText("[e] fermer inventaire\n" + "[enter] selectionné");

        updatePlayer(dungeon.player);
    }
}
