package com.pacgame.provider.component.shape;

import javafx.scene.Node;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class ArcProxy extends ShapeProxy {

    protected Arc proxyObject;

    public ArcProxy(int radius) {
        proxyObject = new Arc();
        proxyObject.setCenterX(0);
        proxyObject.setCenterY(0);
        proxyObject.setRadiusX(radius);
        proxyObject.setRadiusY(radius);
//        this.icon.setStartAngle(45.0f);
//        this.icon.setLength(270.0f);
        proxyObject.setType(ArcType.ROUND);
//
        proxyObject.setRotate(0);
//
//        this.icon.setFill(ColorProvidedObject.YELLOW);
    }

    @Override
    public Arc getProxyObject() {
        return proxyObject;
    }
}
