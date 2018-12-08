package com.pacgame.game;

public class GamePlayLayout {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private IScene scene;
    private ILayer root;

    public GamePlayLayout(ILayer root) {
        this.root = root;
    }

    private void initScene(ISceneFactory sceneFactory)
    {
        this.scene = sceneFactory.createScene(root, WIDTH, HEIGHT);
    }

    public IScene getScene() {

        return scene;
    }
}
