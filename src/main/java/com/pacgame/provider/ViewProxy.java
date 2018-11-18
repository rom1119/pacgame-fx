package com.pacgame.provider;

import com.pacgame.provider.interfaces.ColorableProvider;
import com.pacgame.provider.interfaces.PositionableProvider;
import com.pacgame.provider.interfaces.VisibleProvider;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;
import javafx.scene.Node;

public abstract class ViewProxy extends Proxy implements ColorableProvider, PositionableProvider, Comparable<ViewProxy>, VisibleProvider {
    protected Node proxyObject;

    protected PropertyProvider<Integer> width;
    protected PropertyProvider<Integer> height;
    protected PropertyProvider<Integer> x;
    protected PropertyProvider<Integer> y;
    protected int order;


    public ViewProxy(int width, int height) {
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
    }

    public ViewProxy() {

    }


    @Override
    public boolean isVisible() {
        return proxyObject.isVisible();
    }

    @Override
    public void show() {
        proxyObject.setVisible(true);
    }

    @Override
    public void hide() {
        proxyObject.setVisible(false);
    }

    @Override
    public int compareTo(ViewProxy o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }


    public Node getProxyObject(){
        return proxyObject;
    }

    @Override
    public int getX() {
        return x.get();
    }

    @Override
    public int getY() {
        return y.get();
    }

    @Override
    public PropertyProvider<Integer> XProperty() {
        return x;
    }

    @Override
    public PropertyProvider<Integer> YProperty() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x.set(x);
    }

    @Override
    public void setY(int y) {
        this.y.set(y);
    }



}
