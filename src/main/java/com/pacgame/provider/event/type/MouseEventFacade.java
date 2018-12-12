package com.pacgame.provider.event.type;

import com.pacgame.provider.event.IEventTarget;

public interface MouseEventFacade {

    MouseEvent createEvent(IEventTarget target, Object source, EventType<MouseEvent> eventType);

    EventType<MouseEvent> move();

}
