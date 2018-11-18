package com.pacgame.provider.scene;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.ProvidedObject;

public class SceneProvidedObject extends ProvidedObject implements IScene {
    private SceneProxy proxy;

    public SceneProvidedObject(int width, int height, LayerProvidedObject root) {
        proxy = new SceneProxy(width, height, root.getProxy());
    }

    @Override
    public SceneProxy getProxy() {
        return proxy;
    }

    @Override
    public void setRoot(LayerProvidedObject layer) {
        proxy.setRoot(layer);
    }
}
