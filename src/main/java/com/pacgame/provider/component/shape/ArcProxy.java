package com.pacgame.provider.component.shape;

import com.pacgame.provider.color.Red;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class ArcProxy extends ShapeProxy {

    protected Arc proxyObject;

    public ArcProxy(int radius) {
        proxyObject = new Arc();
//        proxyObject.setCenterX(0);
//        proxyObject.setCenterY(0);
        proxyObject.setRadiusX(radius);
        proxyObject.setRadiusY(radius);
//        this.icon.setStartAngle(45.0f);
        proxyObject.setLength(360.0f);
        proxyObject.setType(ArcType.ROUND);
//
        proxyObject.setRotate(0);
//
        proxyObject.setFill(Color.BLACK);

        proxyObject.setStartAngle(45.0f);
        proxyObject.setLength(270.0f);

    }

    public void setStartAngle(int val)
    {
        getProxyObject().setStartAngle(val);
    }

    public int getStartAngle()
    {
        return (int) getProxyObject().getStartAngle();
    }

    public void setLength(int val)
    {
        getProxyObject().setLength(val);
    }

    public int getLength()
    {
        return (int) getProxyObject().getLength();
    }

    @Override
    public Arc getProxyObject() {
        return proxyObject;
    }

    public void setRadius(int radius)
    {
        getProxyObject().setRadiusX(radius);
        getProxyObject().setRadiusY(radius);
    }
}
