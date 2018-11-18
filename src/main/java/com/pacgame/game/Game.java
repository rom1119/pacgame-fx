package com.pacgame.game;

import com.pacgame.stage.Stage;

public class Game {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private Stage primaryStage;
    private UILayout uiLayout;
    private GamePlayLayout gamePlayLayout;

    private

    public void start()
    {
        primaryStage.show();
    }

    public Game() {
    }

    public void init(IStage Istage)
    {
        primaryStage = Istage.initFromExternalStage();

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PAC-GAME this is new PACMAN :-)");

    }

    public void pause()
    {

    }

    private void buildUILayout()
    {
        uiLayout = new UILayout();
    }

    private void buildGamePlayLayout()
    {
        gamePlayLayout = new GamePlayLayout();
    }
}
