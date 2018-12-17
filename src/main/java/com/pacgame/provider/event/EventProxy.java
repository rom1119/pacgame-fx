package com.pacgame.provider.event;

import com.pacgame.provider.Proxy;
import javafx.event.Event;


public abstract class EventProxy extends Proxy {

    protected Event proxyObject;

    public EventProxy(Event proxyObject) {
        this.proxyObject = proxyObject;
    }

    public EventProxy() {
    }

    public abstract Class<? extends EventProxy> getType();

    protected abstract Event getProxyObject();

    public abstract void setProxyObject(Event event);
}
