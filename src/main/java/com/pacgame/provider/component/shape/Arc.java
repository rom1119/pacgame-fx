package com.pacgame.provider.component.shape;

import com.pacgame.provider.Paint;
import com.pacgame.provider.component.ShapeProvidedObject;
import com.pacgame.provider.property.ArcLengthProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.RadiusProperty;
import com.pacgame.provider.property.StartAngleProperty;

public class Arc extends ShapeProvidedObject {

    protected ArcProxy proxy;
    protected PropertyProvider<Integer> radius;
    protected PropertyProvider<Integer> length;
    protected PropertyProvider<Integer> startAngle;



    public Arc(int radius) {
        proxy = new ArcProxy(radius);
        this.radius = new RadiusProperty(radius);
        this.length = new ArcLengthProperty(0);
        this.startAngle = new StartAngleProperty(0);
    }

    public void setRadius(int radius) {
        this.radius.set(radius);
        getProxy().setRadius(radius);
    }

    public int getRadius()
    {
        return radius.get();
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
