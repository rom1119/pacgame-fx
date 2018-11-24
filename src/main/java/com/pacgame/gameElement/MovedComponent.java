package com.pacgame.gameElement;

import com.pacgame.Component;
import com.pacgame.provider.ComponentProvidedObject;

public abstract class MovedComponent extends GameElement {

    public MovedComponent(int width, int height, ComponentProvidedObject providedObject) {
        super(width, height, providedObject);
    }
}
