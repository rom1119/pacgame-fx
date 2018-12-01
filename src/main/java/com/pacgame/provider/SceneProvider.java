package com.pacgame.provider;

public interface SceneProvider {

    SceneProvidedObject createScene(int width, int height, LayerProvidedObject layer);
}
