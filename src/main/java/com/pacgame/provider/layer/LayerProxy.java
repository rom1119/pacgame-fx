package com.pacgame.provider.layer;

import com.pacgame.IChildren;
import com.pacgame.Parentable;
import com.pacgame.Visible;
import com.pacgame.provider.ViewProxy;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

import java.util.Map;

public abstract class LayerProxy extends ViewProxy implements Visible, Parentable<LayerProxy>, IChildren<ViewProxy> {

    protected Pane proxyObject;

    private LayerProxy parent;
    private Map<String, ViewProxy> children;

    public LayerProxy() {
        super();
    }

    public LayerProxy(int width, int height) {
        super(width, height);
    }

    @Override
    public void addChildren(ViewProxy el) {
        if (!hasChildren(el)) {
            children.put(String.valueOf(el.hashCode()), el);
            proxyObject.getChildren().add(el.getProxyObject());
        }
    }

    @Override
    public void removeChildren(ViewProxy el) {
        if (hasChildren(el)) {
            children.remove(el.hashCode());
        }
    }

    @Override
    public Pane getProxyObject(){
        return proxyObject;
    }


    @Override
    public boolean hasChildren(ViewProxy el) {
        return children.containsKey(el.hashCode());
    }

    @Override
    public void setParent(LayerProxy el) {
        parent = el;
    }

    @Override
    public LayerProxy getParent() {
        return parent;
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

    public void setWidth(int width)
    {
        proxyObject.setPrefWidth(width);
    }

    public void setHeight(int height)
    {
        proxyObject.setPrefHeight(height);
    }

    @Override
    public void setBackground(Paint color) {
        proxyObject.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
