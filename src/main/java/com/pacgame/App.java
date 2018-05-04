package com.pacgame;

import com.pacgame.controller.PacmanController;
import com.pacgame.model.Pacman;
import com.pacgame.view.Factory;
import com.pacgame.view.Map;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class App extends Application {
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
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    public void start(Stage primaryStage) throws Exception {


        Pacman pac = new Pacman(new Point2D(2, 2), 20);

        Group root = new Group();

        Scene scene = new Scene(root, 500, 500);

        Pacman pacman = new Pacman(new Point2D(200, 200), 25);


        Map mapMain = Factory.createMap("./map/map_first.png");
        final PacmanController pacmanController = new PacmanController(pacman, scene);



        root.getChildren().add(mapMain.getView(500, 500));
        root.getChildren().add(pacman.getCollider());
        root.getChildren().add(pacman.getIcon());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PAC-GAME new PACMAN :-)");
        primaryStage.show();

        new Timer().schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        pacmanController.run(1);
                    }
                }, 0, 25);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
