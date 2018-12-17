package com.pacgame.provider.event.type;

import com.pacgame.provider.event.EventProxy;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;

public class KeyEventProxy extends EventProxy {


    public KeyEventProxy(KeyEvent event) {
        super(event);
//        proxyObject = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.ENTER, false, false, false, false);
    }

    public KeyEventProxy() {
    }

    @Override
    public Class<? extends EventProxy> getType() {
        return getClass();
    }

    @Override
    protected KeyEvent getProxyObject() {
        return (KeyEvent) proxyObject;
    }

    @Override
    public void setProxyObject(Event event) {
        if (!(event instanceof KeyEvent)) {
            throw new IllegalArgumentException("Event Argument must be type KeyEvent but passed on " + event.getClass().toString() + " type.");
        }
        proxyObject = event;
    }
}
