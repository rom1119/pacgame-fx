package com.pacgame.provider;

import javafx.scene.Node;

public abstract class ViewProxy extends IProxy {
    protected Node proxyObject;

    public Node getProxyObject(){
        return proxyObject;
    }

}
