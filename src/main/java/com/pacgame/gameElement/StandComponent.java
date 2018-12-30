package com.pacgame.gameElement;


import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.component.ShapeProvidedObject;

public abstract class StandComponent extends GameElement {
    public StandComponent(ShapeProvidedObject providedObject) {
        super(providedObject);
    }
}
