package com.pacgame.provider.component.shape;

import com.pacgame.provider.component.ShapeProvidedObject;

public class Rectangle extends ShapeProvidedObject {

    protected RectangleProxy proxy;

    public Rectangle(int width, int height) {
        proxy = new RectangleProxy(width, height);
    }
}
