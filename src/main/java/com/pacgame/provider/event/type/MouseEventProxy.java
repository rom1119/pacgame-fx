package com.pacgame.provider.event.type;

import com.pacgame.provider.event.EventProxy;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;

public class MouseEventProxy extends EventProxy {

    protected MouseEvent proxyObject;

    public MouseEventProxy() {
    }

    @Override
    protected Event getProxyObject() {
        return proxyObject;
    }
}
