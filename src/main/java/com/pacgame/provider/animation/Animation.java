package com.pacgame.provider.animation;

import com.pacgame.provider.ProvidedObject;
import com.pacgame.provider.Proxy;
import com.pacgame.provider.event.IEventHandlerProvider;
import com.pacgame.provider.event.type.ActionEvent;

public abstract class Animation extends ProvidedObject {

    protected AnimationProxy proxy;

    public void setOnFinished(IEventHandlerProvider<ActionEvent> eventHandler)
    {
        ActionEvent actionEvent = new ActionEvent();
        actionEvent.setSource(this);
        getProxy().setOnFinished(eventHandler, actionEvent);
    }

    @Override
    protected AnimationProxy getProxy() {
        return proxy;
    }

    public abstract void play();
    public abstract void pause();
    public abstract void stop();

}
