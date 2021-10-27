package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Dungeon;
import model.Player;
import view.JavaFXView;
import view.View;

import java.net.URL;

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

        Dungeon dungeon = new Dungeon();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("src/main/java/view/Screen.fxml"));
        BorderPane rootLayout = (BorderPane) loader.load();
        final Scene scene = new Scene(rootLayout, 300, 250);
        primaryStage.setScene(scene);


        JavaFXController javaFXController = new JavaFXController(dungeon);
        scene.setOnKeyPressed(javaFXController.eventHandler);


        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
