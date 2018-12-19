package com.pacgame.provider.event.type;

import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.provider.EventTargetProvidedObject;

public class KeyEventFacadeImpl implements KeyEventFacade {
    @Override
    public KeyEvent createEvent(EventTargetProvidedObject target, Object source, EventTypeProvidedObject eventType) {
        return new KeyEvent(target, source, eventType);
    }

    @Override
    public EventTypeProvidedObject<KeyEvent> keyPressed() {
        return KeyEvent.KEY_PRESSED;
    }

    @Override
    public EventTypeProvidedObject<KeyEvent> any() {
        return KeyEvent.ANY;
    }
}
