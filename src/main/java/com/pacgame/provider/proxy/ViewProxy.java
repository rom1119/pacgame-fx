package com.pacgame.provider.proxy;

import com.pacgame.provider.IProxy;
import javafx.scene.Node;

public abstract class ViewProxy implements IProxy {
    protected Node proxyObject;

    @Override
    public Node getProxyObject() {
        return proxyObject;
    }
}
