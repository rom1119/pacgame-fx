package com.pacgame;


import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.Color;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.WidthProperty;

public abstract class View implements Positionable, Colorable {

    protected ViewProvidedObject providedObject;

    protected Property<Integer> width;
    protected Property<Integer> height;
    protected Property<Integer> x;
    protected Property<Integer> y;

    public View(int width, int height) {
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
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
        providedObject.fill(red, green, blue, alpha);
    }

    @Override
    public void fill(int red, int green, int blue) {
        providedObject.fill(red, green, blue);
    }

    @Override
    public void fillRed() {
        providedObject.fillRed();
    }

    @Override
    public void fillBlue() {
        providedObject.fillBlue();
    }

    @Override
    public void fillGreen() {
        providedObject.fillGreen();
    }

    @Override
    public void fillWhite() {
        providedObject.fillWhite();
    }

    @Override
    public void setColor(Color color) {
        providedObject.setColor(color);
    }
}
