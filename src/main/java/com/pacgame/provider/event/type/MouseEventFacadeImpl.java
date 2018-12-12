package com.pacgame.provider.event.type;

import com.pacgame.provider.event.IEventTarget;

public class MouseEventFacadeImpl implements MouseEventFacade {
    @Override
    public MouseEvent createEvent(IEventTarget target, Object source, EventType<MouseEvent> eventType) {
        return new MouseEvent(target, source, eventType);
    }

    @Override
    public EventType<MouseEvent> move() {
        return MouseEvent.MOUSE_MOVED;
    }
}
