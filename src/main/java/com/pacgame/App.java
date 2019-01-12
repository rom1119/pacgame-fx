package com.pacgame;

import com.pacgame.color.ColorFactory;
import com.pacgame.color.ColorFactoryImpl;
import com.pacgame.event.EventFacade;
import com.pacgame.event.EventFacadeImpl;
import com.pacgame.game.Game;
import com.pacgame.game.GamePlayLayout;
import com.pacgame.game.PlatformTools;
import com.pacgame.game.UILayout;
import com.pacgame.game.adapter.PlatformToolsAdapter;
import com.pacgame.game.adapter.board.BoardMapCreatorAdapter;
import com.pacgame.game.adapter.board.GameObjectFactoryAdapter;
import com.pacgame.game.adapter.board.movement.MovePointsCreatorAdapter;
import com.pacgame.game.adapter.board.movement.MovementFactory;
import com.pacgame.game.adapter.factory.*;
import com.pacgame.game.adapter.StageAdapter;
import com.pacgame.gameElement.GameElementFacade;
import com.pacgame.map.LevelsFacade;
import com.pacgame.provider.*;
import com.pacgame.stage.SceneFactory;
import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.MenuFactory;
import com.pacgame.uiElement.UIFactory;
import com.pacgame.uiElement.alignment.PositionFactory;
import com.pacgame.uiElement.alignment.PositionFactoryImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App extends Application {



//    private static void initApp(Stage primaryStage)
//    {
//        Scene scene = new Scene(new VBox(), 800, 500);
//        Stage stage = new Stage();
//
//
//        Map mapMain = Factory.createMap("./map/map_first.png");
//        mapMain.setOrder(0);
//        allUIComponents = new HashSet<>();
//        allUIComponents.add(mapMain);
//
//        // menuToHide
//
//        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//        primaryStage.setTitle("PAC-GAME this is new PACMAN :-)");
//        primaryStage.show();
//
//
//        mazesCollection = FXCollections.observableArrayList(mazes);
//
//
//        mainMenu.updateFocusMenuOption();
//
//        setOnCloseOperation(primaryStage);
//        setOnEscapeKey(scene, contextMenu);
//    }
//
//    public static Layer getVisibleComponentOnTop()
//    {
//        ArrayList<Layer> objects = new ArrayList<>(allUIComponents);
//        Collections.sort(objects, Collections.reverseOrder());
//
//        for (int i = 0; i <= objects.size(); i++) {
//            System.out.println(objects.get(i));
//            if (objects.get(i).isVisible()) {
//                return objects.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private static void createPacmanController()
//    {
//
//    }
//
//    private static void setOnCloseOperation(Stage primaryStage)
//    {
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            public void handle(WindowEvent event) {
//                exit();
//            }
//        });

//    }
//
//    public static void exit()
//    {
//        clearAllMazesController();
//
//        if (pacmanController.getMovementManager() != null) {
//            pacmanController.getMovementManager().stopAnimation();
//        }
//        if (pacmanController.getMainAnimation() != null) {
//            pacmanController.getMainAnimation().stop();
//
//        }
//        if (pacmanController.getInitTimer() != null) {
//            pacmanController.getInitTimer().stop();
//
//        }
//        Platform.exit();
//    }
//
//    private static void setOnEscapeKey(Scene scene, ContextMenu contextMenu)
//    {
//        scene.addEventHandler(KeyEvent.KEY_PRESSED, new OnEscapeKey(contextMenu));
//    }

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

        // Providers
        UIProvider uiProvider = new UIProviderImpl();
        LayerProvider layerProvider = new LayerProviderImpl();
        SceneProvider sceneProvider = new SceneProviderImpl();
        PaintProvider paintProvider = new PaintProviderImpl();
        PositionAlignmentProvider positionAlignmentProvider = new PositionAlignmentProviderImpl();
        EventProvider eventProvider = new EventProviderImpl();
        ShapeProvider shapeProvider = new ShapeProviderImpl();
        AnimationProvider animationProvider = new AnimationProviderImpl();

        UIFactory uiFacade = new UIFactory(uiProvider, eventProvider);
        LayerFactory layerFactory = new LayerFactory(layerProvider);
        SceneFactory sceneFactory = new SceneFactory(sceneProvider);
        MenuFactory menuFactory = new MenuFactory(uiProvider, layerProvider, positionAlignmentProvider, paintProvider, eventProvider);
        ColorFactory colorFactory = new ColorFactoryImpl(paintProvider);
        PositionFactory positionFactory = new PositionFactoryImpl(positionAlignmentProvider);
        EventFacade eventFacade = new EventFacadeImpl(eventProvider);
        PlatformToolsProvider platformToolsProvider = new PlatformToolsProviderImpl();
        GameElementFacade gameElementFacade = new GameElementFacade(shapeProvider, colorFactory, animationProvider);
        LevelsFacade levelsFacade = new LevelsFacade(colorFactory);

        // Adapters
        StageAdapter stageAdapter = new StageAdapter(primaryStage);
        LayoutFactoryAdapter layoutFactoryAdapter = new LayoutFactoryAdapter(uiFacade, layerFactory, positionFactory);
        SceneFactoryAdapter sceneFactoryAdapter = new SceneFactoryAdapter(sceneFactory);
        MenuFactoryAdapter menuFactoryAdapter = new MenuFactoryAdapter(menuFactory);
        ColorFactoryAdapter colorFactoryAdapter = new ColorFactoryAdapter(colorFactory);
        UIComponentFactoryAdapter uiComponentFactoryAdapter = new UIComponentFactoryAdapter(uiFacade, eventFacade);
        PlatformTools platformToolsAdapter = new PlatformToolsAdapter(platformToolsProvider.platformTools());
        GameObjectFactoryAdapter gameObjectFactoryAdapter = new GameObjectFactoryAdapter(gameElementFacade.movingElementFactory(), eventFacade);
        BoardMapCreatorAdapter boardMapCreatorAdapter = new BoardMapCreatorAdapter(levelsFacade, gameElementFacade, layerFactory, eventFacade);
        MovePointsCreatorAdapter movePointsCreator = new MovePointsCreatorAdapter();
        MovementFactory movementFactory = new MovementFactory(animationProvider.animationBuilder(), movePointsCreator);
        boardMapCreatorAdapter.setMovementFactory(movementFactory);

        // Game
        Game game = new Game(platformToolsAdapter);
        game.init(stageAdapter);

        // UILayout
        UILayout uiLayout = new UILayout(layoutFactoryAdapter.createGroupLayer(Game.WIDTH, Game.HEIGHT), sceneFactoryAdapter, colorFactoryAdapter);

        // GamePlayLayout
        GamePlayLayout gamePlayLayout = new GamePlayLayout(layoutFactoryAdapter.createGroupLayer(Game.WIDTH, Game.HEIGHT), sceneFactoryAdapter);
        gamePlayLayout.setEventFacade(game.getEventFacade());
        gamePlayLayout.createMap(boardMapCreatorAdapter);
        gamePlayLayout.initGameObjects(gameObjectFactoryAdapter);


        game.setUILayout(uiLayout);
        game.showUILayout();
        game.setGamePlayLayout(gamePlayLayout);
        game.showGameLayout();

        uiLayout.createMenus(menuFactoryAdapter, game.getEventFacade());
        uiLayout.buildHiddenViews(layoutFactoryAdapter, uiComponentFactoryAdapter);
//        initApp(primaryStage);
//        play();
    }
}
