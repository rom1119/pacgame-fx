package com.pacgame.provider.event.type;

import com.pacgame.provider.event.EventProxy;
import javafx.event.ActionEvent;
import javafx.event.Event;

public class ActionEventProxy extends EventProxy {


    public ActionEventProxy(ActionEvent event) {
        super(event);
//        proxyObject = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.ENTER, false, false, false, false);
    }

    public ActionEventProxy() {
        proxyObject = new ActionEvent();
    }


    @Override
    public Class<? extends EventProxy> getType() {
        return getClass();
    }

    @Override
    protected ActionEvent getProxyObject() {
        return (ActionEvent) proxyObject;
    }

    @Override
    public void setProxyObject(Event event) {
        if (!(event instanceof ActionEvent)) {
            throw new IllegalArgumentException("Event Argument must be type ActionEvent but passed on " + event.getClass().toString() + " type.");
        }
        proxyObject = event;
    }
}
