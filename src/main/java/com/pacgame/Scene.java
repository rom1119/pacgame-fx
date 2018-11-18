package com.pacgame;

import com.pacgame.Layer;
import com.pacgame.provider.scene.SceneProvidedObject;
import com.pacgame.stage.IScene;

public class Scene implements IScene {

    private SceneProvidedObject providedObject;

    public Scene(SceneProvidedObject providedObject) {
        this.providedObject = providedObject;
    }

    @Override
    public void setRoot(Layer layer) {
        providedObject.setRoot(layer.providedObject);
    }
}
