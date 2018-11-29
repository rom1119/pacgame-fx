package com.pacgame.provider.component;


import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.Paint;
import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.component.ui.UIElementProxy;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;

import java.util.HashMap;

public abstract class UIElementProvidedObject extends ComponentProvidedObject {

    protected UIElementProxy proxy;
    protected PropertyProvider<Integer> width;
    protected PropertyProvider<Integer> height;

    public UIElementProvidedObject() {
        super();
        width = new WidthProperty(0);
        height = new HeightProperty(0);
    }

    public UIElementProvidedObject(int width, int height) {
        this();
        this.width.set(width);
        this.height.set(height);
    }

    public void setBorder(Paint paint, int width)
    {
        proxy.setBorder(paint.getValue(), width);
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
    protected ViewProxy getProxy() {
        return proxy;
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
    public void setX(int x) {
        super.setX(x);
        proxy.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        proxy.setY(y);
    }

    @Override
    public void setBackground(Paint paint) {
        proxy.setBackground(paint.getValue());
    }
}
