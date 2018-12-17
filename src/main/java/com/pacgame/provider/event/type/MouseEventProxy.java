package com.pacgame.provider.event.type;

import com.pacgame.provider.event.EventProxy;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;

class MouseEventProxy extends EventProxy {


    public MouseEventProxy(MouseEvent event) {
        super(event);
    }

    public MouseEventProxy() {
    }

    @Override
    public Class<? extends EventProxy> getType() {
        return getClass();
    }

    @Override
    protected MouseEvent getProxyObject() {
        return (MouseEvent) proxyObject;
    }

    @Override
    public void setProxyObject(Event event) {
        if (!(event instanceof MouseEvent)) {
            throw new IllegalArgumentException("Event Argument must be type MouseEvent but passed on " + event.getClass().toString() + " type.");
        }
        proxyObject = event;
    }


    public boolean isPrimaryButtonDown()
    {
        return getProxyObject().isPrimaryButtonDown();
    }

    public double getX()
    {
        return getProxyObject().getX();
    }
}
