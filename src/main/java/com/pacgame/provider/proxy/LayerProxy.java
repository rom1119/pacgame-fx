package com.pacgame.provider.proxy;

import com.pacgame.IChildren;
import com.pacgame.Parentable;
import com.pacgame.provider.IProxy;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Map;

public abstract class LayerProxy extends ViewProxy implements Parentable<LayerProxy>, IChildren<Node> {

    protected Pane layer;

    private LayerProxy parent;
    private Map<String, Node> children;

    public LayerProxy() {
    }

    public Map<String, Node> getChildren() {
        return children;
    }

    @Override
    public void addChildren(Node el) {
        if (!hasChildren(el)) {
            children.put(String.valueOf(el.hashCode()), el);

        }
    }

    @Override
    public void removeChildren(Node el) {
        if (hasChildren(el)) {
            children.remove(el.hashCode());
        }
    }

    @Override
    public boolean hasChildren(Node el) {
        return children.containsKey(el.hashCode());
    }

    @Override
    public void setParent(LayerProxy el) {

    }

    @Override
    public LayerProxy getParent() {
        return null;
    }
}
