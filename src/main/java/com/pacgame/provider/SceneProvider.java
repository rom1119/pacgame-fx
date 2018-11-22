package com.pacgame.provider;

import com.pacgame.provider.scene.IScene;
import com.pacgame.provider.scene.SceneProvidedObject;

public interface SceneProvider {

    SceneProvidedObject createScene(int width, int height, LayerProvidedObject layer);
}
