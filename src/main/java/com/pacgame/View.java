package com.pacgame;


import com.pacgame.color.Color;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.property.HeightProperty;
import com.pacgame.property.WidthProperty;

public abstract class View implements Positionable, Colorable, Comparable<View>, Visible  {

    protected ViewProvidedObject providedObject;

    protected Property<Integer> width;
    protected Property<Integer> height;
    protected Property<Integer> x;
    protected Property<Integer> y;
    protected int order;


    public View() {
    }

    public View(int width, int height) {
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
    }

    @Override
    public boolean isVisible() {
        return providedObject.isVisible();
    }

    @Override
    public void show() {
        providedObject.show();
    }

    @Override
    public void hide() {
        providedObject.hide();
    }

    @Override
    public int compareTo(View o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
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
    public Property<Integer> XProperty() {
        return x;
    }

    @Override
    public Property<Integer> YProperty() {
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
        providedObject.setColor(color.getProvidedObject());
    }
}
