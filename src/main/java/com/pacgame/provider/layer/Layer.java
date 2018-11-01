package com.pacgame.provider.layer;

import com.pacgame.Component;
import com.pacgame.IChildren;
import com.pacgame.Parentable;
import com.pacgame.provider.proxy.LayerProxy;

import java.util.Map;

public abstract class Layer implements Parentable<Layer>, IChildren<Component> {

    protected LayerProxy layerProxy;

    private Layer parent;
    private Map<String, Component> children;

    @Override
    public Map<String, Component> getChildren() {
        return children;
    }

    @Override
    public void addChildren(Component el) {
        if (!hasChildren(el)) {
            children.put(String.valueOf(el.hashCode()), el);

        }
    }

    @Override
    public void removeChildren(Component el) {
        if (hasChildren(el)) {
            children.remove(el.hashCode());
        }
    }

    @Override
    public boolean hasChildren(Component el) {
        return children.containsKey(el.hashCode());
    }

    @Override
    public void setParent(Layer el) {
        parent = el;
    }

    @Override
    public Layer getParent() {
        return parent;
    }
}
