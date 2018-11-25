package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.Paint;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.property.PropertyProvider;

public class BorderLayer extends LayerProvidedObject {

    protected BorderLayerProxy proxy;

    public BorderLayer() {
        this.proxy = new BorderLayerProxy();
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public void addChildren(ViewProvidedObject el) {
        super.addChildren(el);
    }

    @Override
    public void removeChildren(ViewProvidedObject el) {
        super.removeChildren(el);
    }

    @Override
    public LayerProxy getProxy() {
        return proxy;
    }

    @Override
    public boolean hasChildren(ViewProvidedObject el) {
        return super.hasChildren(el);
    }

    @Override
    public void setParent(LayerProvidedObject el) {
        super.setParent(el);
    }

    @Override
    public LayerProvidedObject getParent() {
        return super.getParent();
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
    public int compareTo(ViewProvidedObject o) {
        return super.compareTo(o);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public PropertyProvider<Integer> XProperty() {
        return super.XProperty();
    }

    @Override
    public PropertyProvider<Integer> YProperty() {
        return super.YProperty();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void setBackground(Paint paint) {
        super.setBackground(paint);
    }
}
