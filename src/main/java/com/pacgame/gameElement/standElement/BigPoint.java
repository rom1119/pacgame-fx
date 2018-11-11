package com.pacgame.gameElement.standElement;

import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.component.ShapeProvidedObject;

public class BigPoint extends EatableElement {

    protected int value = 5;
    protected static final String imageSrc = "./point/big-point.png";

    public BigPoint(int width, int height, ShapeProvidedObject providedObject) {
        super(width, height, providedObject);
    }

    public BigPoint(ShapeProvidedObject providedObject) {
        super(providedObject);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    protected ViewProvidedObject getProvidedObject() {
        return providedObject;
    }
}
