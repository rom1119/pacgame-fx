package com.pacgame.provider.event.type;

import com.pacgame.provider.EventType;
import com.pacgame.provider.event.IEventTarget;

public class KeyEventFacadeImpl implements KeyEventFacade {
    @Override
    public KeyEvent createEvent(IEventTarget target, Object source, EventType eventType) {
        return new KeyEvent(target, source, eventType);
    }

    @Override
    public EventType<KeyEvent> keyPressed() {
        return KeyEvent.KEY_PRESSED;
    }
}
