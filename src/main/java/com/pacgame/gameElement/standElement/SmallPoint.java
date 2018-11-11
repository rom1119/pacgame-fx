package com.pacgame.gameElement.standElement;

import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.component.ShapeProvidedObject;

public class SmallPoint extends EatableElement {

    public SmallPoint(int width, int height, ShapeProvidedObject providedObject) {
        super(width, height, providedObject);
    }

    public SmallPoint(ShapeProvidedObject providedObject) {
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
