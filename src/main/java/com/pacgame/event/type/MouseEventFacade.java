package com.pacgame.event.type;

import com.pacgame.EventType;

public interface MouseEventFacade {

    MouseEvent newEvent(EventTarget target, EventSource source, EventType<MouseEvent> eventType);

    EventType<MouseEvent> onMove();

    EventType<MouseEvent> onClick();

    EventType<MouseEvent> onEnter();

    EventType<MouseEvent> onEnterTarget();

    EventType<MouseEvent> onExitTarget();
}
