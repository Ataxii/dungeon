package view;

import javafx.scene.text.*;
import model.Direction;
import model.Dungeon;
import model.Move;
import model.Player;
import model.loot.Loot;
import model.monster.Monster;
import model.room.Room;

public class JavaFXView implements View{


    public Text playerInformation = new Text(300, 20, "");
    public Text top = new Text(100,100,"Bienvenue dans ce donjon.\n bonne chance pour cette aventure et en esperent que vous surviviez...");
    public Text middle = new Text(100, 200, "");
    public Text commandes = new Text(100 , 300, "[e] Ouvir l'inventaire\n [zqsd] Se déplacer");

    public void updatePlayer(Player player){
        playerInformation.setText("Player : " + player.health + "/" + player.getMaxHealth() + " hp || "
                + player.strength + " de force");

    }

    public void handleMove(Move move){
        top.setText(move.message);
    }

    @Override
    public void room(Room roomType) {
        StringBuilder dialogue = new StringBuilder();
        dialogue.append("Tu es actuellement dans une ").append(roomType.description()).append(", tu peux aller :\n");
        for (Direction direction:
                roomType.getDirections()) {
            dialogue.append("   -").append(direction.name()).append("\n");
        }
        this.top.setText(dialogue.toString());
        commandes.setText("[e] ouvir l'inventaire\n [zqsd] Se déplacer");

    }

    @Override
    public void fight(Player player, Monster monster) {
        String dialogue = "";
        dialogue += "Le monstre que vous allez combattre a " + monster.getStrength() +
                " de force et " + monster.getLife() + " de vie\n";

        if (monster.isAlive()){
            dialogue += "Vous avez malheureusement perdu le combat :(\n";
        }
        else {
            dialogue += "Vous avez gagné le combat !!!";
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
        updatePlayer(player);
    }

    @Override
    public void makeSplit() {
        this.middle.setText("");
    }

    @Override
    public void inventory(Dungeon dungeon) {
        makeSplit();
        StringBuilder selection = new StringBuilder();
        String dialoque = "";
        int i = 0;
        if(dungeon.player.inventory.isEmpty()){
            dialoque += "Ton inventaire est vide!";
        }
        else {
            dialoque+= "Tu as " + dungeon.player.health + "/" + dungeon.player.getMaxHealth() + " hp\n";
            for (Loot loot : dungeon.player.inventory.getLoots()) {

                if(dungeon.player.inventory.getPosition() == i){
                    selection.append("{").append(i).append("}").append(" : ").append(loot.getName()).append(" de ").append(loot.getValue()).append(" hp || ");
                }
                else {
                    selection.append(i).append(" : ").append(loot.getName()).append(" de ").append(loot.getValue()).append(" hp || ");
                }
                i ++;
            }
            dialoque += selection;
        }

        top.setText(dialoque);
        commandes.setText("[e] fermer inventaire\n" + "[enter] selectionné");

        updatePlayer(dungeon.player);
    }
}
