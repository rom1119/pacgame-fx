package com.pacgame.gameElement;

import com.pacgame.Component;
import com.pacgame.event.IEvent;
import com.pacgame.event.target.IGameEventTarget;
import com.pacgame.provider.ComponentProvidedObject;

public abstract class GameElement extends Component implements IGameEventTarget {

    protected ComponentProvidedObject providedObject;

    public GameElement(int width, int height, ComponentProvidedObject providedObject) {
        super(width, height);
        this.providedObject = providedObject;
    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
