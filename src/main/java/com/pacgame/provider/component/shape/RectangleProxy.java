package com.pacgame.provider.component.shape;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class RectangleProxy extends ShapeProxy {

    protected Rectangle proxyObject;

    public RectangleProxy(int width, int height) {
        this.proxyObject = new Rectangle(width, height);
    }

    @Override
    public Rectangle getProxyObject() {
        return proxyObject;
    }

    public int getWidth() {
        return (int) getProxyObject().getWidth();
    }

    public void setWidth(int width) {
        getProxyObject().setWidth(width);
    }

    public int getHeight() {
        return (int) getProxyObject().getHeight();
    }

    public void setHeight(int height) {
        getProxyObject().setHeight(height);
    }

    public void setLayoutX(int i) {
        getProxyObject().setLayoutX(i);
    }

    public void setLayoutY(int i) {
        getProxyObject().setLayoutY(i);
    }
}
