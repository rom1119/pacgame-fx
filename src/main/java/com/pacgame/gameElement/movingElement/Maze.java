package com.pacgame.gameElement.movingElement;

import com.pacgame.color.ColorFactory;
import com.pacgame.color.Paint;
import com.pacgame.gameElement.Eatable;
import com.pacgame.gameElement.MovedComponent;
import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.PaintProvider;
import com.pacgame.provider.component.shape.Rectangle;

public abstract class Maze extends MovedComponent implements Eatable {

    protected int value = 10;
    protected Rectangle providedObject;
    protected ColorFactory colorFactory;

    public Maze( Rectangle providedObject, ColorFactory colorFactory) {
        super(providedObject);
        this.providedObject = providedObject;
        this.colorFactory = colorFactory;
        this.providedObject.setLayoutX(-10);
        this.providedObject.setLayoutY(-15);

        setBackground(colorFactory.image(getCenterBackgroundUrl()));
    }

    public abstract String getUpBackgroundUrl();
    public abstract String getDownBackgroundUrl();
    public abstract String getLeftBackgroundUrl();
    public abstract String getRightBackgroundUrl();
    public abstract String getCenterBackgroundUrl();

    public void turnUp()
    {
        setBackground(colorFactory.image(getUpBackgroundUrl()));
    }

    public void turnDown()
    {
        setBackground(colorFactory.image(getDownBackgroundUrl()));
    }

    public void turnLeft()
    {
        setBackground(colorFactory.image(getLeftBackgroundUrl()));
    }

    public void turnRight()
    {
        setBackground(colorFactory.image(getRightBackgroundUrl()));
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

    @Override
    public void changeToEaten() {

    }
}
