package com.pacgame.stage;

import com.pacgame.Layer;
import com.pacgame.provider.SceneProvidedObject;

public interface IScene {

    void setRoot(Layer layer);

    SceneProvidedObject getProvidedObject();
}
