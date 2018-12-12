package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.event.IEventTarget;

public class KeyEvent extends EventProvidedObject {

    protected KeyEventProxy proxy;

    public static final EventType<KeyEvent> ANY = new EventType<KeyEvent>(null , "KEY");
    public static final EventType<KeyEvent> KEY_PRESSED = new EventType<KeyEvent>(KeyEvent.ANY , "KEY_PRESSED");

    @Override
    protected EventProxy getProxy() {
        return proxy;
    }

    KeyEvent(IEventTarget target, Object source, EventType<KeyEvent> eventType) {
        super(target, source, eventType);
        proxy = new KeyEventProxy();
    }
}
