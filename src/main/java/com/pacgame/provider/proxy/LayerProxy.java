package com.pacgame.provider.proxy;

import com.pacgame.IChildren;
import com.pacgame.Parentable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Map;

public abstract class LayerProxy extends ViewProxy implements Parentable<LayerProxy>, IChildren<ViewProxy> {

    protected Pane proxyObject;

    private LayerProxy parent;
    private Map<String, ViewProxy> children;

    public LayerProxy() {
    }

    @Override
    public Pane getProxyObject() {
        return proxyObject;
    }

    public Map<String, ViewProxy> getChildren() {
        return children;
    }



    @Override
    public void addChildren(ViewProxy el) {
        if (!hasChildren(el)) {
            children.put(String.valueOf(el.hashCode()), el);
            getProxyObject().getChildren().add(el.getProxyObject());
        }
    }

    @Override
    public void removeChildren(ViewProxy el) {
        if (hasChildren(el)) {
            children.remove(el.hashCode());
        }
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
}
