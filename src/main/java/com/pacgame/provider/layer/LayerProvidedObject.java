package com.pacgame.provider.layer;

import com.pacgame.*;
import com.pacgame.provider.ViewProvidedObject;

import java.util.Map;

public abstract class LayerProvidedObject extends ViewProvidedObject implements Parentable<LayerProvidedObject>, IChildren<ViewProvidedObject> {

    protected LayerProxy proxy;

    private LayerProvidedObject parent;
    private Map<String, ViewProvidedObject> children;

    @Override
    public Map<String, ViewProvidedObject> getChildren() {
        return children;
    }

    @Override
    public void addChildren(ViewProvidedObject el) {
        if (!hasChildren(el)) {
            children.put(String.valueOf(el.hashCode()), el);
            proxy.addChildren(el.getProxy());

        }
    }

    @Override
    public void removeChildren(ViewProvidedObject el) {
        if (hasChildren(el)) {
            children.remove(el.hashCode());
        }
    }

    @Override
    public boolean hasChildren(ViewProvidedObject el) {
        return children.containsKey(el.hashCode());
    }

    @Override
    public void setParent(LayerProvidedObject el) {
        parent = el;
    }

    @Override
    public LayerProvidedObject getParent() {
        return parent;
    }
}
