package com.pacgame.provider;

import com.pacgame.Colorable;
import com.pacgame.Positionable;
import com.pacgame.Property;
import com.pacgame.provider.color.Color;
import com.pacgame.property.HeightProperty;
import com.pacgame.property.WidthProperty;

public abstract class ViewProvidedObject extends ProvidedObject implements Positionable, Colorable {

    protected ViewProxy proxy;

    protected Property<Integer> width;
    protected Property<Integer> height;
    protected Property<Integer> x;
    protected Property<Integer> y;

    public ViewProvidedObject() {
    }

    public ViewProvidedObject(int width, int height) {
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
    }

    @Override
    ViewProxy getProxy() {
        return proxy;
    }

    @Override
    public Property<Integer> getX() {
        return x;
    }

    @Override
    public Property<Integer> getY() {
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
