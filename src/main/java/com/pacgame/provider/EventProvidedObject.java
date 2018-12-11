package com.pacgame.provider;

import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.event.IEventTarget;

public abstract class EventProvidedObject extends ProvidedObject {

    @Override
    protected abstract EventProxy getProxy();

    protected IEventTarget target;

    protected Object source;

    protected EventType<? extends EventProvidedObject> eventType;

    public EventProvidedObject(IEventTarget target, Object source, EventType<? extends EventProvidedObject> eventType) {
        this.target = target;
        this.source = source;
        this.eventType = eventType;
    }


}
