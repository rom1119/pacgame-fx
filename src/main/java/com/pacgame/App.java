package com.pacgame;

import com.pacgame.controller.PacmanController;
import com.pacgame.model.Pacman;
import com.pacgame.service.MapPathCreator;
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


        Pacman pac = new Pacman(new Point2D(2, 2), 20);

        Group root = new Group();

        Scene scene = new Scene(root, 500, 500);

        Pacman pacman = new Pacman(new Point2D(0, 0), 13);


        Map mapMain = Factory.createMap("./map/map_first.png");
        final PacmanController pacmanController = new PacmanController(pacman, scene, root);


        Canvas canvas = mapMain.getView(500, 500);

//        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                System.out.println("x= " + event.getX() + ", y= " + event.getY());
//            }
//        });

//        MapPathCreator mapPathCreator = new MapPathCreator();
//
//        PathTransition pathTransition = new PathTransition();

//        pathTransition.onFinishedProperty()

//        List<Point2D> path = mapPathCreator.createPoints(canvas);

//        Path p = new Path();
//
//        MoveTo moveTo = new MoveTo(100, 100);
//        MoveTo moveTo2 = new MoveTo(400, 100);
//        MoveTo moveTo3 = new MoveTo(100, 400);

//        LineTo lineTo = new LineTo(400, 100);
//        LineTo lineTo1 = new LineTo(400, 400);
//        LineTo lineTo2 = new LineTo(100, 400);
//        LineTo lineTo3 = new LineTo(100, 100);
//        LineTo lineTo4 = new LineTo(400, 400);

//        p.getElements().add(moveTo);
//        p.getElements().add(moveTo2);
//        p.getElements().add(moveTo3);
//        p.getElements().add(lineTo);
//        p.getElements().add(lineTo1);
//        p.getElements().add(lineTo2);
//        p.getElements().add(lineTo3);
//        p.getElements().add(lineTo4);

//        PathTransition pathTransition2 = new PathTransition();
//
//
//        pathTransition2.setDuration(Duration.millis(5000));
//        pathTransition2.setNode(pacman.getIcon());
//        pathTransition2.setPath(p);
//
//        pathTransition2.setCycleCount(1);
//        pathTransition2.setAutoReverse(false);
//        pathTransition2.play();
//
//        pathTransition.setDuration(Duration.millis(5000));
//        pathTransition.setNode(pacman.getCollider());
//        pathTransition.setPath(p);
//
//        pathTransition.setCycleCount(1);
//        pathTransition.setAutoReverse(false);
//        pathTransition.play();





        root.getChildren().add(canvas);
        root.getChildren().add(pacman.getCollider());
        root.getChildren().add(pacman.getIcon());
//        root.getChildren().add(mapPathCreator.getPath());

        pacmanController.startEatAnimation();
        pacmanController.startMove();

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
