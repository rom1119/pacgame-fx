package com.pacgame.provider;

import com.pacgame.provider.interfaces.ColorableProvidedProxy;
import com.pacgame.provider.interfaces.ColorableProvider;
import com.pacgame.provider.interfaces.PositionableProvider;
import com.pacgame.provider.interfaces.VisibleProvider;
import com.pacgame.provider.property.*;
import javafx.scene.Node;
import javafx.scene.paint.Paint;

public abstract class ViewProxy extends Proxy implements ColorableProvidedProxy, PositionableProvider, Comparable<ViewProxy>, VisibleProvider {
    protected Paint paint;

    protected PropertyProvider<Integer> x;
    protected PropertyProvider<Integer> y;
    protected int order;


    public ViewProxy() {
        x = new TranslateXProperty(0);
        y = new TranslateYProperty(0);
    }


    @Override
    public boolean isVisible() {
        return getProxyObject().isVisible();
    }

    @Override
    public void show() {
        getProxyObject().setVisible(true);
    }

    @Override
    public void hide() {
        getProxyObject().setVisible(false);
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


    public abstract Node getProxyObject();

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
        getProxyObject().setTranslateX(x);
    }

    @Override
    public void setY(int y) {
        this.y.set(y);
        getProxyObject().setTranslateY(y);
    }

    @Override
    public void setBackground(Paint color) {
        this.paint = color;
    }


}
