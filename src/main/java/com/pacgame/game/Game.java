package com.pacgame.game;

import com.pacgame.game.IEventFacade;
import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.ExitGame;

public class Game {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    private static final String TITTLE = "PAC-GAME this is new PACMAN :-)";
    private IStage primaryStage;
    private UILayout uiLayout;
    private GamePlayLayout gamePlayLayout;
    private StageFactory stageFactory;
    private IEventFacade eventFacade;
    private PlatformTools platformTools;


    public void start()
    {
        primaryStage.show();
    }

    public Game(PlatformTools platformTools) {

        eventFacade = new EventFacadeImpl();
        this.platformTools = platformTools;
    }

    public void init(IStage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(true);
        this.primaryStage.setTitle(TITTLE);

    }

    private void setOnExitGame()
    {
        eventFacade.appEventFacade().addEventHandler(eventFacade.appEventFacade().exitGame(), e -> {
            e.setPlatformTools(platformTools);
            e.exit();
        });
    }

    public void pause()
    {

    }

    public void showUILayout()
    {
      primaryStage.setScene(uiLayout.getScene());
      primaryStage.show();
    }

    public void showGameLayout()
    {
        primaryStage.setScene(gamePlayLayout.getScene());
    }

    public void buildGamePlayLayout(ILayoutFactory layoutFactory)
    {
        gamePlayLayout = new GamePlayLayout(layoutFactory.createGroupLayer(WIDTH, HEIGHT));
    }

    public void setUILayout(UILayout uiLayout) {
        this.uiLayout = uiLayout;

        uiLayout.initScene( WIDTH, HEIGHT);

    }

    public IEventFacade getEventFacade() {
        return eventFacade;
    }
}
