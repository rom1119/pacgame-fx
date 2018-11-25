package com.pacgame.provider;

import com.pacgame.provider.interfaces.ColorableProvider;
import com.pacgame.provider.interfaces.PositionableProvider;
import com.pacgame.provider.interfaces.VisibleProvider;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;

public abstract class ViewProvidedObject extends ProvidedObject implements PositionableProvider, ColorableProvider, Comparable<ViewProvidedObject>, VisibleProvider {

    protected ViewProxy proxy;

    protected PropertyProvider<Integer> width;
    protected PropertyProvider<Integer> height;
    protected PropertyProvider<Integer> x;
    protected PropertyProvider<Integer> y;
    protected int order;


    public ViewProvidedObject() {
        this.width = new WidthProperty(0);
        this.height = new HeightProperty(0);
    }

    public ViewProvidedObject(int width, int height) {
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
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
    public int compareTo(ViewProvidedObject o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }

    @Override
    protected ViewProxy getProxy() {
        return proxy;
    }

    @Override
    public int getX() {
        return x.get();
    }

    @Override
    public int getY() {
        return y.get();
    }

    @Override
    public PropertyProvider<Integer> XProperty() {
        return x;
    }

    @Override
    public PropertyProvider<Integer> YProperty() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x.set(x);
    }

    @Override
    public void setY(int y) {
        this.y.set(y);
    }

    @Override
    public void setBackground(Paint paint) {
        proxy.setBackground(paint.getValue());
    }
}
