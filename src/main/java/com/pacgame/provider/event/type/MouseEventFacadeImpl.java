package com.pacgame.provider.event.type;

import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.provider.EventTargetProvidedObject;

public class MouseEventFacadeImpl implements MouseEventFacade {
    @Override
    public MouseEvent createEvent(EventTargetProvidedObject target, Object source, EventTypeProvidedObject eventType) {
        return new MouseEvent(target, source, eventType);
    }

    @Override
    public EventTypeProvidedObject<MouseEvent> any() {
        return MouseEvent.ANY;
    }

    @Override
    public EventTypeProvidedObject<MouseEvent> move() {
        return MouseEvent.MOUSE_MOVED;
    }

    @Override
    public EventTypeProvidedObject<MouseEvent> click() {
        return MouseEvent.MOUSE_CLICKED;
    }

    @Override
    public EventTypeProvidedObject<MouseEvent> enter() {
        return MouseEvent.MOUSE_ENTERED;
    }

    @Override
    public EventTypeProvidedObject<MouseEvent> enterTarget() {
        return MouseEvent.MOUSE_ENTERED_TARGET;
    }

    @Override
    public EventTypeProvidedObject<MouseEvent> exitTarget() {
        return MouseEvent.MOUSE_EXITED_TARGET;
    }
}
