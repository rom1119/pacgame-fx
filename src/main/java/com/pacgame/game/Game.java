package com.pacgame.game;

public class Game {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
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
        this.primaryStage.setTitle("PAC-GAME this is new PACMAN :-)");

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

    public void buildUILayout(ILayoutFactory layoutFactory, ISceneFactory sceneFactory)
    {
        uiLayout = new UILayout(layoutFactory.createGroupLayer(), sceneFactory);

    }

    public void buildGamePlayLayout(ILayoutFactory layoutFactory)
    {
        gamePlayLayout = new GamePlayLayout(layoutFactory.createGroupLayer());
    }
}
