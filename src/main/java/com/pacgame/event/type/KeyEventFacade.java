package com.pacgame.event.type;

import com.pacgame.EventType;

public interface KeyEventFacade {

    KeyEvent newEvent(EventTarget target, EventSource source, EventType<KeyEvent> eventType);

    EventType<KeyEvent> onKeyPressed();

}
