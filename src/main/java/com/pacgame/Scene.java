package com.pacgame;

import com.pacgame.provider.SceneProvider;
import com.pacgame.provider.SceneProvidedObject;
import com.pacgame.stage.IScene;

public class Scene implements IScene {

    private SceneProvidedObject providedObject;

    public Scene(SceneProvider provider, int width, int height, Layer layer) {
        this.providedObject = provider.createScene(width, height, layer.getProvidedObject());
    }

    @Override
    public void setRoot(Layer layer) {
        providedObject.setRoot(layer.getProvidedObject());
    }

    @Override
    public SceneProvidedObject getProvidedObject() {
        return providedObject;
    }
}
