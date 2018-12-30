package com.pacgame.gameElement;

import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.component.ShapeProvidedObject;

public abstract class MovedComponent extends GameElement {

    public MovedComponent(ShapeProvidedObject providedObject) {
        super(providedObject);
    }
}
