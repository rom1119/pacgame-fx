package com.pacgame.stage;

import com.pacgame.Layer;
import com.pacgame.provider.scene.SceneProvidedObject;

public interface IScene {

    void setRoot(Layer layer);

    SceneProvidedObject getProvidedObject();
}
