package com.pacgame.stage;

import com.pacgame.Layer;
import com.pacgame.Scene;
import com.pacgame.provider.SceneProvider;

public class SceneFactory {

    private SceneProvider sceneProvider;

    public SceneFactory(SceneProvider sceneProvider) {
        this.sceneProvider = sceneProvider;
    }

    public IScene createScene(Layer root, int width, int height)
    {
        return new Scene(sceneProvider, width, height, root);
    }
}
