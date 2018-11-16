package com.pacgame.provider.component.shape;

import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class ArcProxy extends ShapeProxy {

    protected Arc proxyObject;

    public ArcProxy(int radius) {
        this.proxyObject = new Arc();
        this.proxyObject.setCenterX(0);
        this.proxyObject.setCenterY(0);
        this.proxyObject.setRadiusX(radius);
        this.proxyObject.setRadiusY(radius);
//        this.icon.setStartAngle(45.0f);
//        this.icon.setLength(270.0f);
        this.proxyObject.setType(ArcType.ROUND);
//
        this.proxyObject.setRotate(0);
//
//        this.icon.setFill(ColorProvidedObject.YELLOW);
    }

}
