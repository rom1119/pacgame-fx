package com.pacgame.gameElement;

import com.pacgame.Component;
import com.pacgame.event.IEvent;
import com.pacgame.event.target.IGameEventTarget;
import com.pacgame.provider.ComponentProvidedObject;

public abstract class GameElement extends Component implements IGameEventTarget {


    public GameElement( ComponentProvidedObject providedObject) {
        super();
    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
