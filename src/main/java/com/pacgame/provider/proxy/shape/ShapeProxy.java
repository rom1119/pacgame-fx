package com.pacgame.provider.proxy.shape;

import com.pacgame.provider.proxy.ComponentProxy;
import javafx.scene.Node;
import javafx.scene.shape.Shape;

public abstract class ShapeProxy extends ComponentProxy {

    protected Shape proxyObject;

    @Override
    public Shape getProxyObject() {
        return proxyObject;
    }
}
