package com.pacgame;

import com.pacgame.controller.MazeController;
import com.pacgame.controller.PacmanController;
import com.pacgame.event.MazeEvent;
import com.pacgame.event.eventHandler.OnEscapeKey;
import com.pacgame.event.eventHandler.OnPacmanTouchMaze;
import com.pacgame.service.MapPathCreator;
import com.pacgame.service.PointPopulator;
import com.pacgame.view.*;
import com.pacgame.view.Map;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.util.*;

public class App extends Application {

    private static final int DELAY = 2000;

    public static Group root;
    public static ObservableList<MazeController> mazesCollection;
    public static EntryTimer entryTimer;

    private static PacmanController pacmanController;
    private static MazeController mazeControllerNew;
    private static boolean running = true;
    private static Timeline mazeCreateTimeline;
    private static MainMenu mainMenu;

    public static boolean isRunning() {
        return running;
    }

    public static void setRunning(boolean running) {
        App.running = running;
    }

    public static void play()
    {
        setRunning(true);

        if (entryTimer.getTimer().getStatus() != Animation.Status.STOPPED) {
            if (entryTimer != null) {
                entryTimer.play();
            }
            return;
        }
        if (pacmanController != null) {
            pacmanController.getMovementManager().playAnimation();
            pacmanController.playInitTimer();
            pacmanController.playMainAnimation();
        }
        if (mazeCreateTimeline != null) {
            mazeCreateTimeline.play();

        }

        playAllMazes();
    }

    public static void pause()
    {
        setRunning(false);

        if (pacmanController != null) {
            pacmanController.getMovementManager().pauseAnimation();
            pacmanController.pauseInitTimer();
            pacmanController.pauseMainAnimation();
        }
        if (mazeCreateTimeline != null) {
            mazeCreateTimeline.pause();

        }
        if (entryTimer != null) {
            entryTimer.pause();
        }
        pauseAllMazes();

    }

    private static void playAllMazes()
    {
        for (MazeController mazeController: mazesCollection) {
            mazeController.playStateTimeline();
            mazeController.getMovementManager().playAnimation();
            mazeController.playInitTimer();
            mazeController.playMainAnimation();
        }
    }

    private static void pauseAllMazes()
    {
        for (MazeController mazeController: mazesCollection) {
            mazeController.pauseStateTimeline();
            mazeController.getMovementManager().pauseAnimation();
            mazeController.pauseInitTimer();
            mazeController.pauseMainAnimation();
        }
    }

    public static void main(String[] args)
    {
        launch(args);

    }

    public static void clearAllMazesController(Group root)
    {
        for (MazeController mazeContr : mazesCollection) {
//                    MazeController mazeContr = mazesCollection.get(i);
            clearMazeController(mazeContr, root);
//                    mazesCollection.remove(mazeContr);
        }

//        clearMazeController(mazeController, root);
//        clearMazeController(mazeControllerNew, root);
        mazesCollection.clear();
        System.gc();
        Runtime.getRuntime().gc();
    }

    private static void clearMazeController(MazeController mazeController, Group root)
    {
        if (mazeController.getStateTimeline() != null) {
            mazeController.getStateTimeline().pause();
        }
        mazeController.setStateTimeline(null);
        if (mazeController.getMovementManager() != null) {

            mazeController.getMovementManager().stopAnimation();
        }
        if (mazeController.getInitTimer() != null) {

            mazeController.pauseInitTimer();
        }
        mazeController.setInitTimer(null);

        if (mazeController.getMainAnimation() != null) {

            mazeController.pauseMainAnimation();
        }
        mazeController.setMainAnimation(null);

        if (mazeController.getControlledObject() != null) {
            mazeController.getControlledObject().getCollider().removeEventHandler(MazeEvent.TOUCH, new OnPacmanTouchMaze());

            root.getChildren().remove(mazeController.getControlledObject().getCollider());
            root.getChildren().remove(mazeController.getControlledObject().getIcon());


        }
        mazeController.setControlledObject(null);
        mazeController.setMovementManager(null);

    }

    public static void run(Stage primaryStage)
    {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                initApp(primaryStage);
            }
        }, DELAY, 1);
    }

    public static void createMazeTimeline(Group root)
    {
        MazeController mazeController = new MazeController(root);
        mazeController.setPacmanController(pacmanController);
        mazeController.initialize();
        mazeController.initFinder(pacmanController);
        mazeController.startMove();

//        mazeController.getMovementManager().setScore(scoreUIControll);


        mazesCollection.add(mazeController);
//        MazeController mazeControllerNew;

        mazeCreateTimeline = new Timeline();
        mazeCreateTimeline.setCycleCount(Timeline.INDEFINITE);
//        mazeCreateTimeline.setDelay(Duration.millis(4000));
        mazeCreateTimeline.getKeyFrames().add(
            new KeyFrame(Duration.millis(4000),
                    new EventHandler<ActionEvent>() {
                        // KeyFrame event handler
                        public void handle(ActionEvent event) {

                            if (mazesCollection.size() >= MazeController.MAX_AMOUNT_MAZES - 1) {
    //                                    timeline.stop();
                                return;
                            }

                            mazeControllerNew = new MazeController(root);
                            mazeControllerNew.setPacmanController(pacmanController);
                            mazeControllerNew.initialize();
                            mazeControllerNew.initFinder(pacmanController);
                            mazeControllerNew.startMove();
                            mazeControllerNew.playStateTimeline();
                            mazeControllerNew.getMovementManager().playAnimation();
                            mazeControllerNew.playInitTimer();
                            mazeControllerNew.playMainAnimation();

                            mazesCollection.add(mazeControllerNew);




                        }
                    }));
    }

    private static void initApp(Stage primaryStage)
    {
        root = new Group();
        Scene scene = new Scene(root, 800, 500);

        Map mapMain = Factory.createMap("./map/map_first.png");

        GameInfo gameInfo = Factory.createGameInfo();
        mainMenu = Factory.createMainMenu(scene);

        entryTimer = Factory.createEntryTimer();

        Node gameCanvas = mapMain.getView(500, 500);
        root.getChildren().add(gameCanvas);

        Node entryTimerEl = entryTimer.getView(500, 500);


        Node gameInfoPane = gameInfo.getView(300, 500);
        Label scoreUIControll = gameInfo.getScore();
        Label livesUIControll = gameInfo.getLives();
        gameInfoPane.setTranslateX(500);
        root.getChildren().add(gameInfoPane);

        Node mainMenuPane = mainMenu.getView(500, 500);
//        Label scoreUIControll = gameInfo.getScore();
//        Label livesUIControll = gameInfo.getLives();
//        gameInfoPane.setTranslateX(500);

        ObservableList<Point> allPoints = PointPopulator.populate(MapPathCreator.getAllPoints(), root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PAC-GAME new PACMAN :-)");
        primaryStage.show();

        pacmanController = new PacmanController(scene, root);
        pacmanController.scoreProperty().bindBidirectional(scoreUIControll.textProperty());
        pacmanController.getControlledObject().livesProperty().bindBidirectional(livesUIControll.textProperty());
        pacmanController.setAllPoints(allPoints);
        pacmanController.initialize();



        List<MazeController> mazes = new ArrayList();
        mazesCollection = FXCollections.observableArrayList(mazes);


        createMazeTimeline(root);

        entryTimer.setPacmanController(pacmanController);

        root.getChildren().add(entryTimerEl);
        root.getChildren().add(mainMenuPane);


//        mazeCreateTimeline.playFromStart();

        pacmanController.setMazeControllerList(mazesCollection);
        pacmanController.startEatAnimation();

//        Button btn = new Button("usuń");
//        btn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, new EventHandler<javafx.scene.input.MouseEvent>() {
//            @Override
//            public void handle(javafx.scene.input.MouseEvent event) {
////                System.out.println(mazesCollection.size());
////                timeline.pause();
////                clearAllMazesController(root);
////                entryTimerEl.setVisible(false);
//
//            }
//        });

//        root.getChildren().add(btn);


        setOnCloseOperation(primaryStage);
        setOnEscapeKey(scene);
    }

    private static void createPacmanController()
    {

    }

    private static void setOnCloseOperation(Stage primaryStage)
    {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                exit();
            }
        });
    }

    public static void exit()
    {
        clearAllMazesController(root);

        pacmanController.getMovementManager().stopAnimation();
        pacmanController.getMainAnimation().stop();
        pacmanController.getInitTimer().stop();
        Platform.exit();
    }

    private static void setOnEscapeKey(Scene scene)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new OnEscapeKey(scene, mainMenu));
    }

    @Override
    public void stop()
    {


    }

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

        initApp(primaryStage);
//        play();
        setRunning(false);
        mainMenu.updateFocusMenuOption();
    }
}
