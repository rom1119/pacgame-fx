package com.pacgame.provider.scene;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.ViewProvidedObject;

public class Scene extends ViewProvidedObject {
    private SceneProxy proxy;

    public Scene(int width, int height, LayerProvidedObject layerProvidedObject) {
        super(width, height);
        proxy = new SceneProxy(width, height, layerProvidedObject.getProxy());
    }
}
