package com.pacgame.provider;

import com.pacgame.*;
import com.pacgame.provider.layer.LayerProxy;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;

import java.util.HashMap;
import java.util.Map;

public abstract class LayerProvidedObject extends ViewProvidedObject implements Visible, Parentable<LayerProvidedObject>, IChildren<ViewProvidedObject> {

    protected LayerProxy proxy;
    protected PropertyProvider<Integer> width;
    protected PropertyProvider<Integer> height;

    private LayerProvidedObject parent;
    protected Map<String, ViewProvidedObject> children;

    public LayerProvidedObject() {
        super();
        children = new HashMap<>();
        width = new WidthProperty(0);
        height = new HeightProperty(0);
    }

    public LayerProvidedObject(int width, int height) {
        this();
        this.width.set(width);
        this.height.set(height);
    }

    public void setWidth(int width)
    {
        this.width.set(width);
    }

    public void setHeight(int height)
    {
        this.height.set(height);
    }

    public void setBorder(Paint paint, int width)
    {
        proxy.setBorder(paint.getValue(), width);
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
    public LayerProxy getProxy() {
        return proxy;
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
        return proxy.isVisible();
    }

    @Override
    public void show() {
        proxy.show();
    }

    @Override
    public void hide() {
        proxy.hide();
    }

    @Override
    public void setBackground(Paint paint) {
        proxy.setBackground(paint.getValue());
    }
}
