package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.provider.EventTargetProvidedObject;

public class KeyEvent extends EventProvidedObject {

    protected KeyEventProxy proxy;

    public static final EventTypeProvidedObject ANY = new EventTypeProvidedObject(null , "KEY", KeyEvent.class );
    public static final EventTypeProvidedObject KEY_PRESSED = new EventTypeProvidedObject(KeyEvent.ANY , "KEY_PRESSED", KeyEvent.class);

    @Override
    protected KeyEventProxy getProxy() {
        return proxy;
    }

    KeyEvent(EventTargetProvidedObject target, Object source, EventTypeProvidedObject eventType) {
        super(target, source, eventType);
        proxy = new KeyEventProxy();
    }

    public KeyEvent() {
        this(null, null, null);

    }

    public boolean isArrowUp()
    {
        return getProxy().isArrowUp();
    }

    public boolean isArrowBottom()
    {
        return getProxy().isArrowBottom();
    }

    public boolean isArrowLeft()
    {
        return getProxy().isArrowLeft();
    }

    public boolean isArrowRight()
    {
        return getProxy().isArrowRight();
    }

    public boolean isEnter()
    {
        return getProxy().isEnter();
    }
}
