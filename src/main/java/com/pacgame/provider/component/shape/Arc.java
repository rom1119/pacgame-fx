package com.pacgame.provider.component.shape;

import com.pacgame.provider.Paint;
import com.pacgame.provider.component.ShapeProvidedObject;
import com.pacgame.provider.property.ArcLengthProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.RadiusProperty;
import com.pacgame.provider.property.StartAngleProperty;

public class Arc extends ShapeProvidedObject {

    protected ArcProxy proxy;
    protected PropertyProvider<Integer> radiusX;
    protected PropertyProvider<Integer> radiusY;
    protected PropertyProvider<Integer> length;
    protected PropertyProvider<Integer> startAngle;



    public Arc(int radius) {
        proxy = new ArcProxy(radius);
        this.radiusX = new RadiusProperty(radius);
        this.radiusY = new RadiusProperty(radius);
        this.length = new ArcLengthProperty(0);
        this.startAngle = new StartAngleProperty(0);
        this.length.setOnChangeProperty((old , newVal) -> {
            getProxy().setLength(newVal);
        });

        this.startAngle.setOnChangeProperty((old , newVal) -> {
            getProxy().setStartAngle(newVal);
        });
    }

    public void setRadius(int radius) {
        this.radiusX.set(radius);
        this.radiusY.set(radius);
        getProxy().setRadius(radius);
    }

    public int getRadiusX()
    {
        return radiusX.get();
    }

    public int getRadiusY()
    {
        return radiusY.get();
    }

    @Override
    public boolean isVisible() {
        return proxy.isVisible();
    }

    @Override
    public void show() {
        proxy.show();
    }

    @Override
    public void hide() {
        proxy.hide();
    }

    @Override
    protected ArcProxy getProxy() {
        return proxy;
    }

    @Override
    public void setWidth(int val) {
        radiusX.set(val);
    }

    @Override
    public int getWidth() {
        return radiusX.get();
    }

    @Override
    public void setHeight(int val) {
        radiusY.set(val);
    }

    @Override
    public int getHeight() {
        return radiusY.get();
    }

    @Override
    public void setBackground(Paint paint) {
        proxy.setBackground(paint.getProxy());
    }

    public void setStartAngle(int val)
    {
        startAngle.set(val);
        getProxy().setStartAngle(val);
    }

    public int getStartAngle()
    {
        return startAngle.get();
    }

    public void setLength(int val)
    {
        length.set(val);
        getProxy().setLength(val);
    }

    @Override
    public void setX(int x) {
//        System.out.println("X: " + x);
        super.setX(x);
    }

    @Override
    public void setY(int y) {
//        System.out.println("Y: " + y);

        super.setY(y);
    }

    public int getLength()
    {
        return length.get();
    }

    public PropertyProvider<Integer> lengthProperty() {
        return length;
    }

    public PropertyProvider<Integer> startAngleProperty() {
        return startAngle;
    }
}
