package com.pacgame;

import com.pacgame.controller.MazeController;
import com.pacgame.controller.PacmanController;
import com.pacgame.model.Pacman;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.PointPopulator;
import com.pacgame.view.Factory;
import com.pacgame.view.GameInfo;
import com.pacgame.view.Map;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import javafx.scene.shape.Path;


import java.util.ArrayList;
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
        Scene scene = new Scene(root, 800, 500);

        Map mapMain = Factory.createMap("./map/map_first.png");

        GameInfo gameInfo = Factory.createGameInfo();

        Node gameCanvas = mapMain.getView(500, 500);
        root.getChildren().add(gameCanvas);

        gameCanvas = (Canvas) gameCanvas;
        ((Canvas) gameCanvas).getGraphicsContext2D();

        Node gameInfoPane = gameInfo.getView(300, 500);
        Label scoreUIControll = gameInfo.getScoreLabel();
//        scoreUIControll.textProperty().set("4444");
//        scoreUIControll.setText("asdfg");
        gameInfoPane.setTranslateX(500);
        root.getChildren().add(gameInfoPane);

        PointPopulator.populate(MapPathCreator.getAllPoints(), root);


        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PAC-GAME new PACMAN :-)");
        primaryStage.show();

        final Timer timer = new Timer();

        PacmanController pacmanController = new PacmanController(scene, root);
//        pacmanController.scoreProperty().bindBidirectional(scoreUIControll.textProperty());
//        pacmanController.scoreProperty().set("2222");
        pacmanController.initialize();
        pacmanController.startEatAnimation();
        pacmanController.startMove();

        List<MazeController> mazes = new ArrayList();
        ObservableList<MazeController> mazesCollection = FXCollections.observableArrayList(mazes);

        MazeController mazeController = new MazeController(root);
        mazeController.initialize();
        mazeController.initFinder(pacmanController);
        mazeController.getMovementManager().setScore(scoreUIControll);

        mazeController.startMove();

        mazesCollection.add(mazeController);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(5000),
                        new EventHandler<ActionEvent>() {
                            // KeyFrame event handler
                            public void handle(ActionEvent event) {

                                if (mazesCollection.size() >= MazeController.MAX_AMOUNT_MAZES) {
                                    timeline.stop();
                                }

                                MazeController mazeControllerNew = new MazeController(root);
                                mazeControllerNew.initialize();
                                mazeControllerNew.initFinder(pacmanController);
                                mazeControllerNew.startMove();

                                mazesCollection.add(mazeControllerNew);




                            }
                        }));


        timeline.playFromStart();




//

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                timeline.stop();
                int countMazes = mazesCollection.size();
                int mazeTimerEnd = 0;
                while(mazeTimerEnd < countMazes) {
                    for (MazeController maze: mazesCollection) {
                        if (maze.getMovementManager().getTimer() != null) {
                            maze.getMovementManager().getTimer().cancel();
                            maze.getMovementManager().setTimer(null);
                            mazeTimerEnd++;
                        }

                    }
//                    System.out.println(mazeTimerEnd);
                }
                pacmanController.getMovementManager().getTimer().cancel();
                pacmanController.getMovementManager().setTimer(null);
//                Platform.exit();
            }
        });
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
