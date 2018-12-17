package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.EventType;
import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.event.IEventTarget;

public class KeyEvent extends EventProvidedObject {

    protected KeyEventProxy proxy;

    public static final EventType ANY = new EventType(null , "KEY", KeyEvent.class );
    public static final EventType KEY_PRESSED = new EventType(KeyEvent.ANY , "KEY_PRESSED", KeyEvent.class);

    @Override
    protected EventProxy getProxy() {
        return proxy;
    }

    KeyEvent(IEventTarget target, Object source, EventType eventType) {
        super(target, source, eventType);
        proxy = new KeyEventProxy();
    }

    public KeyEvent() {
        this(null, null, null);

    }
}
