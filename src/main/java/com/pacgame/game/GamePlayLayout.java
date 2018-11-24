package com.pacgame.game;

public class GamePlayLayout {

    private IScene scene;
    private ILayer root;

    public GamePlayLayout(ILayer root) {
        this.root = root;
    }

    private void initScene(ISceneFactory sceneFactory)
    {
        this.scene = sceneFactory.createScene(root);
    }

    public IScene getScene() {

        return scene;
    }
}
