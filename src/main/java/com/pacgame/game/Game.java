package com.pacgame.game;

public class Game {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    private static final String TITTLE = "PAC-GAME this is new PACMAN :-)";
    private IStage primaryStage;
    private UILayout uiLayout;
    private GamePlayLayout gamePlayLayout;
    private StageFactory stageFactory;


    public void start()
    {
        primaryStage.show();
    }

    public Game() {
    }

    public void init(IStage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);
        this.primaryStage.setTitle(TITTLE);

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
}
