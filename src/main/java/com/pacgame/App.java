package com.pacgame;

import com.pacgame.controller.PacmanController;
import com.pacgame.model.Pacman;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.PointPopulator;
import com.pacgame.view.Factory;
import com.pacgame.view.Map;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import javafx.scene.shape.Path;


import java.util.List;
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

        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);

        Map mapMain = Factory.createMap("./map/map_first.png");

        Canvas canvas = mapMain.getView(500, 500);
        root.getChildren().add(canvas);

        final PacmanController pacmanController = new PacmanController(scene, root);
        pacmanController.initialize();
        pacmanController.startEatAnimation();
        pacmanController.startMove();


        PointPopulator.populate(MapPathCreator.getAllPoints(), root);



        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PAC-GAME new PACMAN :-)");
        primaryStage.show();


//        final Timer timer = new Timer();
//
//        timer.schedule(
//                new TimerTask() {
//
//                    @Override
//                    public void run() {
//                        pacmanController;
//                    }
//                }, 0, 25);
//
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            public void handle(WindowEvent event) {
//                timer.cancel();
//            }
//        });
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
