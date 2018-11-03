package com.pacgame;

import com.pacgame.board.event.eventHandler.OnEscapeKey;
import com.pacgame.ui.component.board.Map;
import com.pacgame.ui.component.contextmenu.ContextMenu;
import com.pacgame.ui.service.Factory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class App extends Application {

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


    private static void initApp(Stage primaryStage)
    {
        Scene scene = new Scene(new VBox(), 800, 500);


        Map mapMain = Factory.createMap("./map/map_first.png");
        mapMain.setOrder(0);

        allUIComponents = new HashSet<>();
        allUIComponents.add(mapMain);

        // menuToHide

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PAC-GAME this is new PACMAN :-)");
        primaryStage.show();


        mazesCollection = FXCollections.observableArrayList(mazes);


        mainMenu.updateFocusMenuOption();

        setOnCloseOperation(primaryStage);
        setOnEscapeKey(scene, contextMenu);
    }

    public static Layer getVisibleComponentOnTop()
    {
        ArrayList<Layer> objects = new ArrayList<>(allUIComponents);
        Collections.sort(objects, Collections.reverseOrder());

        for (int i = 0; i <= objects.size(); i++) {
            System.out.println(objects.get(i));
            if (objects.get(i).isVisible()) {
                return objects.get(i);
            }
        }

        return null;
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

        if (pacmanController.getMovementManager() != null) {
            pacmanController.getMovementManager().stopAnimation();
        }
        if (pacmanController.getMainAnimation() != null) {
            pacmanController.getMainAnimation().stop();

        }
        if (pacmanController.getInitTimer() != null) {
            pacmanController.getInitTimer().stop();

        }
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

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        initApp(primaryStage);
//        play();
    }
}
