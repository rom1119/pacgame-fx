package com.pacgame;

import com.pacgame.board.controller.MazeController;
import com.pacgame.board.controller.PacmanController;
import com.pacgame.board.event.MazeEvent;
import com.pacgame.board.event.eventHandler.OnEscapeKey;
import com.pacgame.board.event.eventHandler.OnPacmanTouchMaze;
import com.pacgame.board.model.User;
import com.pacgame.board.service.MapPathCreator;
import com.pacgame.board.service.PointPopulator;
import com.pacgame.ui.component.*;
import com.pacgame.ui.component.Map;
import com.pacgame.ui.service.Factory;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
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
    public static PacmanController pacmanController;
    public static EntryTimer entryTimer;
    public static MainMenu mainMenu;
    public static int indexForMaze = 0;

    private static MazeController mazeControllerNew;

    private static boolean playing = false;
    private static boolean runningGame = false;
    private static SimpleBooleanProperty loggedUser;

    static {
        loggedUser = new SimpleBooleanProperty();
        loggedUser.set(false);
    }

    public static User user;
    private static Timeline mazeCreateTimeline;

    public static MainMenu getMainMenu() {
        return mainMenu;
    }

    public static void setMainMenu(MainMenu mainMenu) {
        App.mainMenu = mainMenu;
    }

    public static boolean isPlaying() {
        return playing;
    }

    public static void setPlaying(boolean playing) {
        App.playing = playing;
    }

    public static boolean isRunningGame() {
        return runningGame;
    }

    public static void setRunningGame(boolean runningGame) {
        App.runningGame = runningGame;
    }

    public static boolean isLoggedUser() {
        return loggedUser.get();
    }

    public static SimpleBooleanProperty loggedUserProperty() {
        return loggedUser;
    }

    public static void setLoggedUser(boolean loggedUser) {
        App.loggedUser.set(loggedUser);
        mainMenu.updateMenuElementsVisibility(loggedUser);
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        App.user = user;
    }

    public static void play()
    {
        setPlaying(true);

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
        setPlaying(false);

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

    public static void clearAllMazesController()
    {
        for (MazeController mazeContr : mazesCollection) {
            clearMazeController(mazeContr, root);
        }

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

            mazeController.getMovementManager().pauseAnimation();
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

        mazesCollection.add(mazeController);

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
        entryTimer = Factory.createEntryTimer();
        mainMenu = Factory.createMainMenu(scene);
        ContextMenu contextMenu = Factory.createContextMenu(scene);
        MainSettings mainSettings = Factory.createMainSettings();
        ContextSettings contextSettings = Factory.createContextSettings();
        ContextSaveGame contextSaveGame = Factory.createContextSaveGame();
        MainReadGame mainReadGame = Factory.createMainReadGame();
        UserAccount userAccount = Factory.createUserAccount();
        LoginForm loginForm = Factory.createLoginForm();
        RegisterForm registerForm = Factory.createRegisterForm();

        mainMenu.setMainSettings(mainSettings);
        mainMenu.setLoginForm(loginForm);
        mainMenu.setRegisterForm(registerForm);
        mainMenu.setUserAccount(userAccount);
        mainMenu.setMainReadGame(mainReadGame);
        contextMenu.setContextSettings(contextSettings);
        contextMenu.setContextSaveGame(contextSaveGame);
        mainSettings.setMenu(mainMenu);
        contextSettings.setMenu(contextMenu);
        contextSaveGame.setMenu(contextMenu);
        mainReadGame.setMenu(mainMenu);
        userAccount.setMenu(mainMenu);
        loginForm.setRegisterForm(registerForm);
        registerForm.setLoginForm(loginForm);

        Node gameCanvas = mapMain.getView(500, 500);
        Node entryTimerEl = entryTimer.getView(500, 500);
        Node gameInfoPane = gameInfo.getView(300, 500);
        Label scoreUIControll = gameInfo.getScore();
        Label livesUIControll = gameInfo.getLives();
        gameInfoPane.setTranslateX(500);

        // menuToHide
        Node mainMenuPane = mainMenu.getView(500, 500);
        Node contextMenuPane = contextMenu.getView(500, 500);

        // settings
        Node mainSettingsPane = mainSettings.getView(500, 500);
        Node contextSettingsPane = contextSettings.getView(500, 500);
        Node contextSaveGamePane = contextSaveGame.getView(500, 500);
        Node mainReadGamePane = mainReadGame.getView(500, 500);
        Node loginFormPane = loginForm.getView(500, 500);
        Node registerFormPane = registerForm.getView(500, 500);
        Node userAccountPane = userAccount.getView(500, 500);


        root.getChildren().add(gameCanvas);
        root.getChildren().add(gameInfoPane);

        ObservableList<Point> allPoints = PointPopulator.populate(MapPathCreator.getAllPoints(), root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PAC-GAME this is new PACMAN :-)");
        primaryStage.show();

        pacmanController = new PacmanController(scene, root);
        pacmanController.scoreProperty().bindBidirectional(scoreUIControll.textProperty());
        pacmanController.getControlledObject().livesProperty().bindBidirectional(livesUIControll.textProperty());
        pacmanController.setAllPoints(allPoints);
        pacmanController.initialize();



        List<MazeController> mazes = new ArrayList();
        mazesCollection = FXCollections.observableArrayList(mazes);


        contextSaveGame.setMazeCollection(mazesCollection);
        contextSaveGame.setPacmanController(pacmanController);

        entryTimer.setPacmanController(pacmanController);

        root.getChildren().add(entryTimerEl);
        root.getChildren().add(mainMenuPane);
        root.getChildren().add(mainSettingsPane);
        root.getChildren().add(contextMenuPane);
        root.getChildren().add(contextSettingsPane);
        root.getChildren().add(contextSaveGamePane);
        root.getChildren().add(mainReadGamePane);
        root.getChildren().add(loginFormPane);
        root.getChildren().add(registerFormPane);
        root.getChildren().add(userAccountPane);


        indexForMaze = root.getChildren().indexOf(entryTimerEl);
//        mazeCreateTimeline.playFromStart();

        pacmanController.setMazeControllerList(mazesCollection);
        pacmanController.startEatAnimation();

        createMazeTimeline(root);

        mainMenu.updateFocusMenuOption();

        mainSettings.setPacmanController(pacmanController);
        mainSettings.setMazeCollection(mazesCollection);
        contextSettings.setPacmanController(pacmanController);
        contextSettings.setMazeCollection(mazesCollection);


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
        setOnEscapeKey(scene, contextMenu);
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
        clearAllMazesController();

        pacmanController.getMovementManager().stopAnimation();
        pacmanController.getMainAnimation().stop();
        pacmanController.getInitTimer().stop();
        Platform.exit();
    }

    private static void setOnEscapeKey(Scene scene, ContextMenu contextMenu)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new OnEscapeKey(contextMenu));
    }

    @Override
    public void stop()
    {

    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin playing.
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
        setPlaying(false);
    }
}
