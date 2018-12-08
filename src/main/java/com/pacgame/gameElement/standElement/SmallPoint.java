package com.pacgame.gameElement.standElement;

import com.pacgame.color.Paint;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.component.shape.Rectangle;

public class SmallPoint extends EatableElement {

    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    protected Rectangle providedObject;

    public SmallPoint(int width, int height, Rectangle providedObject) {
        super(width, height, providedObject);
        this.providedObject = providedObject;
        this.providedObject.setWidth(width);
        this.providedObject.setHeight(height);
    }

    public SmallPoint(Rectangle providedObject) {
        super(providedObject);
        this.providedObject = providedObject;

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

}
