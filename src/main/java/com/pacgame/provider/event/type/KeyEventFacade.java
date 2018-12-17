package com.pacgame.provider.event.type;

import com.pacgame.provider.EventType;
import com.pacgame.provider.event.IEventTarget;

public interface KeyEventFacade {

    KeyEvent createEvent(IEventTarget target, Object source, EventType eventType);

    EventType<KeyEvent> keyPressed();

}
