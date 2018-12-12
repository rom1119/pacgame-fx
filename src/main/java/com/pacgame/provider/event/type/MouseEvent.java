package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.event.IEventTarget;

public class MouseEvent extends EventProvidedObject {
    protected MouseEventProxy proxy;

    protected static final EventType<MouseEvent> ANY = new EventType<MouseEvent>(null , "MOUSE");
    protected static final EventType<MouseEvent> MOUSE_MOVED = new EventType<MouseEvent>(MouseEvent.ANY , "MOUSE_MOVED");

    @Override
    protected EventProxy getProxy() {
        return proxy;
    }

    MouseEvent(IEventTarget target, Object source, EventType<MouseEvent> eventType) {
        super(target, source, eventType);
    }
}
