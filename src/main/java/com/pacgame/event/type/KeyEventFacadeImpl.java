package com.pacgame.event.type;

import com.pacgame.EventType;
import com.pacgame.provider.EventTargetProvidedObject;

public class KeyEventFacadeImpl implements KeyEventFacade {

    private com.pacgame.provider.event.type.KeyEventFacade keyEventFacade;

    public KeyEventFacadeImpl(com.pacgame.provider.event.type.KeyEventFacade keyEventFacade) {
        this.keyEventFacade = keyEventFacade;
        KeyEvent.ANY = new EventType<KeyEvent>(null , "KEY", KeyEvent.class , keyEventFacade.any());
        KeyEvent.KEY_PRESSED = new EventType<KeyEvent>(KeyEvent.ANY , "KEY_PRESSED", KeyEvent.class , keyEventFacade.keyPressed());

    }

    @Override
    public KeyEvent newEvent(EventTarget target, EventSource source, EventType<KeyEvent> eventType) {
        KeyEvent keyEvent = new KeyEvent(target, source, eventType);
        keyEvent.setProvidedObject(keyEventFacade.createEvent((EventTargetProvidedObject) target.getProvidedObject(), source.getProvidedObject(), eventType.getProvidedObject()));
        return keyEvent;
    }

    @Override
    public EventType<KeyEvent> onKeyPressed() {
        return KeyEvent.KEY_PRESSED;
    }
}
