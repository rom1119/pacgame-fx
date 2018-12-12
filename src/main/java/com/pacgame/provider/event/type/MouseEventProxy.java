package com.pacgame.provider.event.type;

import com.pacgame.provider.event.EventProxy;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;

class MouseEventProxy extends EventProxy {

    protected MouseEvent proxyObject;

    public MouseEventProxy() {
    }

    @Override
    public Class<? extends EventProxy> getType() {
        return getClass();
    }

    @Override
    protected Event getProxyObject() {
        return proxyObject;
    }
}
