package controller;

import com.sun.javafx.fxml.builder.URLBuilder;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Dungeon;
import model.Player;
import view.ConsoleView;
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
        JavaFXController javaFXController = new JavaFXController(dungeon);
        Group root = new Group();

        /**
        URL url1 = getClass().getResource("Screen.fxml");
        // Création du loader.
        final FXMLLoader fxmlLoader = new FXMLLoader(url1);
        // Chargement du FXML.
        final AnchorPane root = fxmlLoader.load();
        // Création de la scène. **/
        final Scene scene = new Scene(root, 300, 250);


        scene.setOnKeyPressed(javaFXController.eventHandler);
        primaryStage.setScene(scene);

        primaryStage.show();

    }



}
