package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.EventType;
import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.event.IEventTarget;

public class MouseEvent extends EventProvidedObject {
    protected MouseEventProxy proxy;

    public static final EventType<MouseEvent> ANY = new EventType<MouseEvent>(null , "MOUSE");
    public static final EventType<MouseEvent> MOUSE_MOVED = new EventType<MouseEvent>(MouseEvent.ANY , "MOUSE_MOVED");

    @Override
    protected EventProxy getProxy() {
        return proxy;
    }

    public MouseEvent(IEventTarget target, Object source, EventType<? extends EventProvidedObject> eventType) {
        super(target, source, eventType);
    }
}
