package com.pacgame.gameElement.standElement;

import com.pacgame.color.Paint;
import com.pacgame.provider.component.shape.Arc;

public class BigPoint extends GamePoint {

    protected int value = 5;
    protected static final String imageSrc = "./point/big-point.png";
    protected Arc providedObject;

    public BigPoint(int radius, Arc providedObject) {
        super(providedObject);
        this.providedObject = providedObject;
        this.providedObject.setRadius(radius);
    }

    public BigPoint(Arc providedObject) {
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
    protected Arc getProvidedObject() {
        return providedObject;
    }

    @Override
    public void setX(int x) {
        super.setX(x );
    }

    @Override
    public void setY(int y) {
        super.setY(y );
    }
}
