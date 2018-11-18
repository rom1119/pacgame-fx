package com.pacgame.provider.scene;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.Proxy;
import com.pacgame.provider.layer.LayerProxy;
import javafx.scene.Scene;

public class SceneProxy extends Proxy implements IScene {

    protected Scene proxyObject;

    public SceneProxy(int width, int height, LayerProxy root) {
        this.proxyObject = new Scene(root.getProxyObject(), width, height);
    }

    public Scene getProxyObject() {
        return proxyObject;
    }


    @Override
    public void setRoot(LayerProvidedObject layer) {
        proxyObject.setRoot(layer.getProxy().getProxyObject());
    }
}
