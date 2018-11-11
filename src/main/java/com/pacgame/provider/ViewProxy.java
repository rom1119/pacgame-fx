package com.pacgame.provider;

import com.pacgame.Colorable;
import com.pacgame.Positionable;
import javafx.scene.Node;

public abstract class ViewProxy extends Proxy implements Colorable, Positionable {
    protected Node proxyObject;

    protected int width;
    protected int height;
    protected int x;
    protected int y;

    public ViewProxy(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public ViewProxy() {

    }

    public Node getProxyObject(){
        return proxyObject;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }


}
