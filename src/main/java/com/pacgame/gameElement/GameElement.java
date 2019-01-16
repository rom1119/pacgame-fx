package com.pacgame.gameElement;

import com.pacgame.Component;
import com.pacgame.event.IEvent;
import com.pacgame.event.target.IGameEventTarget;
import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.component.ShapeProvidedObject;

public abstract class GameElement extends Component {

    protected ShapeProvidedObject providedObject;

    public GameElement(ShapeProvidedObject providedObject) {
        this.providedObject = providedObject;
    }

    @Override
    protected ShapeProvidedObject getProvidedObject() {
        return providedObject;
    }

    public boolean touching(GameElement el)
    {
        return getProvidedObject().intersectHeight(el.getProvidedObject()) > 4 && getProvidedObject().intersectWidth(el.getProvidedObject()) > 4;
    }


//    @Override
//    public IEvent dispatchEvent(IEvent event) {
//        return null;
//    }
}
