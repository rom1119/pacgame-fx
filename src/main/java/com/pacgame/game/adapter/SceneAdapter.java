package com.pacgame.game.adapter;

import com.pacgame.game.ILayer;
import com.pacgame.game.IScene;
import javafx.scene.Scene;

public class SceneAdapter implements IScene {

    private com.pacgame.stage.IScene scene;

    public SceneAdapter(com.pacgame.stage.IScene scene) {
        this.scene = scene;
    }

    @Override
    public void setRoot(ILayer layer) {
        this.scene.setRoot(((LayerAdapter)layer).getProvidedObject());
    }

    com.pacgame.stage.IScene getProvidedObject()
    {
        return scene;
    }
}
