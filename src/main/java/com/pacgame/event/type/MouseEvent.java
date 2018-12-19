package com.pacgame.event.type;

import com.pacgame.EventType;
import com.pacgame.provider.EventProvidedObject;

public class MouseEvent extends Event {

    protected static EventType<MouseEvent> ANY ;
    protected static EventType<MouseEvent> MOUSE_MOVED ;
    protected static EventType<MouseEvent> MOUSE_CLICKED ;
    protected static EventType<MouseEvent> MOUSE_ENTERED ;
    protected static EventType<MouseEvent> MOUSE_ENTERED_TARGET ;
    protected static EventType<MouseEvent> MOUSE_EXITED_TARGET ;

    protected EventProvidedObject providedObject;

    @Override
    protected com.pacgame.provider.event.type.MouseEvent getProvidedObject() {
        return (com.pacgame.provider.event.type.MouseEvent) providedObject;
    }

    @Override
    public void setProvidedObject(EventProvidedObject eventProvidedObject) {

    }

    MouseEvent(EventTarget target, Object source, EventType eventType) {
        super(target, source, eventType);
//        proxy = new MouseEventProxy();
    }

    public MouseEvent() {
        this(null, null, null);
    }

    public boolean isPrimaryButtonDown()
    {
        return getProvidedObject().isPrimaryButtonDown();
    }

    public double getX()
    {
        return getProvidedObject().getX();
    }
}
