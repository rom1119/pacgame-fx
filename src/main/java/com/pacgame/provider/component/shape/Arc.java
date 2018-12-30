package com.pacgame.provider.component.shape;

import com.pacgame.provider.Paint;
import com.pacgame.provider.component.ShapeProvidedObject;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.RadiusProperty;

public class Arc extends ShapeProvidedObject {

    protected ArcProxy proxy;
    protected PropertyProvider<Integer> radius;



    public Arc(int radius) {
        proxy = new ArcProxy(radius);
        this.radius = new RadiusProperty(radius);
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
}
