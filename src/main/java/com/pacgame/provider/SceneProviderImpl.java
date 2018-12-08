package com.pacgame.provider;

public class SceneProviderImpl implements SceneProvider {

    @Override
    public SceneProvidedObject createScene(int width, int height, LayerProvidedObject layer) {
        return new SceneProvidedObject(width, height, layer);
    }
}
