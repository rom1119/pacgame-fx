package com.pacgame.gameElement.standElement;

import com.pacgame.Property;
import com.pacgame.color.Paint;
import com.pacgame.property.HeightProperty;
import com.pacgame.property.WidthProperty;
import com.pacgame.provider.component.shape.Rectangle;

public class SmallPoint extends GamePoint {

    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    protected Rectangle providedObject;
    protected Property<Integer> width;
    protected Property<Integer> height;

    public SmallPoint(int width, int height, Rectangle providedObject) {
        this( providedObject);
        setWidth(width);
        setHeight(height);
    }

    public SmallPoint(Rectangle providedObject) {
        super(providedObject);
        this.providedObject = providedObject;
        this.width = new WidthProperty(0);
        this.height = new HeightProperty(0);

    }

    public int getWidth() {
        return (int) this.width.get();
    }

    public void setWidth(int width) {
        this.width.set(width);
        getProvidedObject().setWidth(width);
    }

    public int getHeight() {
        return (int) this.height.get();
    }

    public void setHeight(int height) {
        this.height.set(height);
        getProvidedObject().setHeight(height);
    }



    @Override
    public int getValue() {
        return value;
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
    public void setBackground(Paint color) {
        providedObject.setBackground(color.getValue());
    }

    @Override
    protected Rectangle getProvidedObject() {
        return providedObject;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        getProvidedObject().setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        getProvidedObject().setY(y);
    }

}
