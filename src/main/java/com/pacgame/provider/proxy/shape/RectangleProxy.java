package com.pacgame.provider.proxy.shape;

import javafx.scene.shape.Rectangle;

public class RectangleProxy extends ShapeProxy {

    protected Rectangle proxyObject;

    @Override
    public Rectangle getProxyObject() {
        return proxyObject;
    }
}
