package com.pacgame.provider;

import com.pacgame.provider.color.Color;

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
    ViewProxy getProxy() {
        return proxy;
    }

    @Override
    public PropertyProvider<Integer> getX() {
        return x;
    }

    @Override
    public PropertyProvider<Integer> getY() {
        return y;
    }

    @Override
    public void fill(int red, int green, int blue, double alpha) {
        proxy.fill(red, green, blue, alpha);
    }

    @Override
    public void fill(int red, int green, int blue) {
        proxy.fill(red, green, blue);
    }

    @Override
    public void fillRed() {
        proxy.fillRed();
    }

    @Override
    public void fillBlue() {
        proxy.fillBlue();
    }

    @Override
    public void fillGreen() {
        proxy.fillGreen();
    }

    @Override
    public void fillWhite() {
        proxy.fillWhite();
    }

    @Override
    public void setColor(Color color) {
        proxy.setColor(color);
    }
}
