package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.EventType;
import com.pacgame.provider.event.IEventTarget;

public class MouseEvent extends EventProvidedObject {
    protected MouseEventProxy proxy;

    protected static final EventType<MouseEvent> ANY = new EventType<>(null , "MOUSE", MouseEvent.class);
    protected static final EventType<MouseEvent> MOUSE_MOVED = new EventType<>(MouseEvent.ANY , "MOUSE_MOVED", MouseEvent.class);
    protected static final EventType<MouseEvent> MOUSE_CLICKED = new EventType<>(MouseEvent.ANY , "MOUSE_CLICKED", MouseEvent.class);

    @Override
    protected MouseEventProxy getProxy() {
        return proxy;
    }

    MouseEvent(IEventTarget target, Object source, EventType eventType) {
        super(target, source, eventType);
        proxy = new MouseEventProxy();
    }

    public MouseEvent() {
        this(null, null, null);
    }

    public boolean isPrimaryButtonDown()
    {
        return proxy.isPrimaryButtonDown();
    }

    public double getX()
    {
        return proxy.getX();
    }
}
