package controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Dungeon;
import model.Player;
import model.loot.Potion;
import view.ConsoleView;
import view.JavaFXView;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        JavaFXView view = new JavaFXView();
        ConsoleView consoleView = new ConsoleView();

        Text main = view.top;
        Text inventory = view.commandes;
        Text fight = view.middle;
        Text playerInfo = view.playerInformation;

        root.getChildren().add(main);
        root.getChildren().add(inventory);
        root.getChildren().add(fight);
        root.getChildren().add(playerInfo);

        root.getChildren().add(new Canvas(800,400));

        Scene scene = new Scene(root);
        Player player = new Player(20, 600);
        player.getInventory().addLoot(new Potion());
        Dungeon dungeon = new Dungeon(player, view, consoleView);

        JavaFXController javaFXController = new JavaFXController(dungeon);

        scene.setOnKeyPressed(javaFXController.eventHandler);
        primaryStage.setScene(scene);
        primaryStage.show();

        view.updatePlayer(dungeon.getPlayer());
    }

}
