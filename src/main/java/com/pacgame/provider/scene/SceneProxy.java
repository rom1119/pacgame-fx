package com.pacgame.provider.scene;

import com.pacgame.provider.Proxy;
import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.provider.layer.LayerProxy;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneProxy extends Proxy {

    protected Scene proxyObject;

    public SceneProxy(int width, int height, LayerProxy layerProxy) {
        this.proxyObject = new Scene(layerProxy.getProxyObject(), width, height);
    }

    public Scene getProxyObject() {
        return proxyObject;
    }


}
