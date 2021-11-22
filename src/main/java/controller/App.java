package controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Dungeon;
import model.loot.Potion;
import view.JavaFXView;

public class App extends Application {
    /*

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();


        JavaFXView view = new JavaFXView();
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
        Dungeon dungeon = new Dungeon(view);
        dungeon.player.inventory.addLoot(new Potion());
        JavaFXController javaFXController = new JavaFXController(dungeon);

        scene.setOnKeyPressed(javaFXController.eventHandler);
        primaryStage.setScene(scene);

        primaryStage.show();
        view.updatePlayer(dungeon.player);
    }
}
