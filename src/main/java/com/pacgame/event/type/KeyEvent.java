package com.pacgame.event.type;

import com.pacgame.EventType;
import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.event.type.KeyEventFacade;

public class KeyEvent extends Event {

    protected EventProvidedObject providedObject;

    public static EventType<KeyEvent> ANY;
    public static EventType<KeyEvent> KEY_PRESSED;

    @Override
    protected com.pacgame.provider.event.type.KeyEvent getProvidedObject() {
        return (com.pacgame.provider.event.type.KeyEvent) providedObject;
    }

    @Override
    public void setProvidedObject(EventProvidedObject eventProvidedObject) {
        providedObject = eventProvidedObject;
    }




    KeyEvent(EventTarget target, Object source, EventType<KeyEvent> eventType) {
        super(target, source, eventType);
//        proxy = new KeyEventProxy();
    }

    public KeyEvent() {
        this(null, null, null);
//        this.providedObject = providerFacade.
    }

    public boolean isArrowUp()
    {
        return getProvidedObject().isArrowUp();
    }

    public boolean isArrowBottom()
    {
        return getProvidedObject().isArrowBottom();
    }

    public boolean isArrowLeft()
    {
        return getProvidedObject().isArrowLeft();
    }

    public boolean isArrowRight()
    {
        return getProvidedObject().isArrowRight();
    }


}
