package com.pacgame.provider.event.type;

import com.pacgame.provider.EventType;
import com.pacgame.provider.event.IEventTarget;

public class MouseEventFacadeImpl implements MouseEventFacade {
    @Override
    public MouseEvent createEvent(IEventTarget target, Object source, EventType eventType) {
        return new MouseEvent(target, source, eventType);
    }

    @Override
    public EventType<MouseEvent> move() {
        return MouseEvent.MOUSE_MOVED;
    }

    @Override
    public EventType<MouseEvent> click() {
        return MouseEvent.MOUSE_CLICKED;
    }

    @Override
    public EventType<MouseEvent> enter() {
        return MouseEvent.MOUSE_ENTERED;
    }

    @Override
    public EventType<MouseEvent> enterTarget() {
        return MouseEvent.MOUSE_ENTERED_TARGET;
    }

    @Override
    public EventType<MouseEvent> exitTarget() {
        return MouseEvent.MOUSE_EXITED_TARGET;
    }
}
