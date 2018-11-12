package com.pacgame.provider;

import com.pacgame.Colorable;
import com.pacgame.Positionable;
import com.pacgame.Property;
import com.pacgame.property.HeightProperty;
import com.pacgame.property.WidthProperty;
import javafx.scene.Node;

public abstract class ViewProxy extends Proxy implements Colorable, Positionable {
    protected Node proxyObject;

    protected Property<Integer> width;
    protected Property<Integer> height;
    protected Property<Integer> x;
    protected Property<Integer> y;

    public ViewProxy(int width, int height) {
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
    }

    public ViewProxy() {

    }

    public Node getProxyObject(){
        return proxyObject;
    }

    @Override
    public Property<Integer> getX() {
        return x;
    }

    @Override
    public Property<Integer> getY() {
        return y;
    }



}
