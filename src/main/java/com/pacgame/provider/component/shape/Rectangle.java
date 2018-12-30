package com.pacgame.provider.component.shape;

import com.pacgame.provider.Paint;
import com.pacgame.provider.component.ShapeProvidedObject;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;

public class Rectangle extends ShapeProvidedObject {

    protected RectangleProxy proxy;
    protected PropertyProvider<Integer> width;
    protected PropertyProvider<Integer> height;

    public Rectangle(int width, int height) {
        proxy = new RectangleProxy(width, height);
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
    }

    public void setWidth(int width) {
        this.width.set(width);
        getProxy().setWidth(width);
    }

    public void setHeight(int height) {
        this.height.set(height);
        getProxy().setHeight(height);
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
    protected RectangleProxy getProxy() {
        return proxy;
    }

    @Override
    public void setBackground(Paint paint) {
        proxy.setBackground(paint.getProxy());
    }
}
