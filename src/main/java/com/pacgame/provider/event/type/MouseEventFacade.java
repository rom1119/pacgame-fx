package com.pacgame.provider.event.type;

import com.pacgame.provider.EventType;
import com.pacgame.provider.event.IEventTarget;

public interface MouseEventFacade {

    MouseEvent createEvent(IEventTarget target, Object source, EventType eventType);

    EventType<MouseEvent> move();

    EventType<MouseEvent> click();

    EventType<MouseEvent> enter();

    EventType<MouseEvent> enterTarget();

    EventType<MouseEvent> exitTarget();

}
