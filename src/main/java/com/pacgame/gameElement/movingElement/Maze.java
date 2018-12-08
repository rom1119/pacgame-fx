package com.pacgame.gameElement.movingElement;

import com.pacgame.color.Paint;
import com.pacgame.gameElement.MovedComponent;
import com.pacgame.gameElement.Valuable;
import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.component.shape.Rectangle;

public abstract class Maze extends MovedComponent implements Valuable {

    protected int value = 10;
    protected Rectangle providedObject;

    public Maze(int width, int height, Rectangle providedObject) {
        super(providedObject);
        this.providedObject = providedObject;
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
    public int getValue() {
        return value;
    }
}
