package com.pacgame.provider;

import com.pacgame.*;
import com.pacgame.provider.layer.LayerProxy;

import java.util.Map;

public abstract class LayerProvidedObject extends ViewProvidedObject implements Parentable<LayerProvidedObject>, IChildren<ViewProvidedObject> {

    protected LayerProxy proxy;

    private LayerProvidedObject parent;
    private Map<String, ViewProvidedObject> children;

    public void setWidth(int width)
    {
        this.width = width;
        proxy.setWidth(width);
    }

    public void setHeight(int height)
    {
        this.height = height;
        proxy.setHeight(height);
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
