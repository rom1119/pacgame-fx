package com.pacgame.provider.event.type;

import com.pacgame.provider.event.EventProxy;
import javafx.scene.input.KeyEvent;

public class KeyEventProxy extends EventProxy {

    protected KeyEvent proxyObject;

    public KeyEventProxy() {
//        proxyObject = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.ENTER, false, false, false, false);
    }

    @Override
    public Class<? extends EventProxy> getType() {
        return getClass();
    }

    @Override
    protected KeyEvent getProxyObject() {
        return proxyObject;
    }
}
