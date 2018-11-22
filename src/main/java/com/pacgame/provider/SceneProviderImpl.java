package com.pacgame.provider;

import com.pacgame.provider.scene.SceneProvidedObject;

public class SceneProviderImpl implements SceneProvider {

    @Override
    public SceneProvidedObject createScene(int width, int height, LayerProvidedObject layer) {
        return new SceneProvidedObject(width, height, layer);
    }
}
