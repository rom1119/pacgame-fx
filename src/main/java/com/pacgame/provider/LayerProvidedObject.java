package com.pacgame.provider;

import com.pacgame.*;
import com.pacgame.provider.layer.LayerProxy;

import java.util.Map;

public abstract class LayerProvidedObject extends ViewProvidedObject implements Visible, Parentable<LayerProvidedObject>, IChildren<ViewProvidedObject> {

    protected LayerProxy proxy;

    private LayerProvidedObject parent;
    private Map<String, ViewProvidedObject> children;

    public void setWidth(int width)
    {
        this.width.set(width);
        proxy.setWidth(width);
    }

    public void setHeight(int height)
    {
        this.height.set(height);
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
            proxy.removeChildren(el.getProxy());
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

    @Override
    public boolean isVisible() {
        return parent.isVisible();
    }

    @Override
    public void show() {
        proxy.show();
    }

    @Override
    public void hide() {
        proxy.hide();
    }
}
