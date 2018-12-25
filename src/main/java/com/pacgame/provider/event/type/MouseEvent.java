package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.provider.EventTargetProvidedObject;

public class MouseEvent extends EventProvidedObject {
    protected MouseEventProxy proxy;

    protected static final EventTypeProvidedObject<MouseEvent> ANY = new EventTypeProvidedObject<>(null , "MOUSE", MouseEvent.class);
    protected static final EventTypeProvidedObject<MouseEvent> MOUSE_MOVED = new EventTypeProvidedObject<>(MouseEvent.ANY , "MOUSE_MOVED", MouseEvent.class);
    protected static final EventTypeProvidedObject<MouseEvent> MOUSE_CLICKED = new EventTypeProvidedObject<>(MouseEvent.ANY , "MOUSE_CLICKED", MouseEvent.class);
    protected static final EventTypeProvidedObject<MouseEvent> MOUSE_ENTERED = new EventTypeProvidedObject<>(MouseEvent.ANY , "MOUSE_ENTERED", MouseEvent.class);
    protected static final EventTypeProvidedObject<MouseEvent> MOUSE_ENTERED_TARGET = new EventTypeProvidedObject<>(MouseEvent.ANY , "MOUSE_ENTERED_TARGET", MouseEvent.class);
    protected static final EventTypeProvidedObject<MouseEvent> MOUSE_EXITED_TARGET = new EventTypeProvidedObject<>(MouseEvent.ANY , "MOUSE_EXITED_TARGET", MouseEvent.class);

    @Override
    protected MouseEventProxy getProxy() {
        return proxy;
    }

    MouseEvent(EventTargetProvidedObject target, Object source, EventTypeProvidedObject eventType) {
        super(target, source, eventType);
        proxy = new MouseEventProxy();
    }

    public MouseEvent() {
        this(null, null, null);
    }

    public boolean isPrimaryButtonDown()
    {
        return getProxy().isPrimaryButtonDown();
    }

    public boolean isMiddleButtonDown()
    {
        return getProxy().isMiddleButtonDown();
    }

    public boolean isSecondaryButtonDown()
    {
        return getProxy().isSecondaryButtonDown();
    }

    public double getX()
    {
        return proxy.getX();
    }
}
