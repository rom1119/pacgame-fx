package com.pacgame.provider.component.shape;

import javafx.scene.shape.Rectangle;

public class RectangleProxy extends ShapeProxy {

    protected Rectangle proxyObject;

    public RectangleProxy(int width, int height) {
        this.proxyObject = new Rectangle(width, height);
    }

}
