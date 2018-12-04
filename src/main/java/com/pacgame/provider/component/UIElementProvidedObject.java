package com.pacgame.provider.component;


import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.Paint;
import com.pacgame.provider.component.ui.UIElementProxy;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;

public abstract class UIElementProvidedObject extends ComponentProvidedObject {

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
        getProxy().setBorder(paint.getProxy(), width);
    }


    @Override
    public boolean isVisible() {
        return getProxy().isVisible();
    }

    @Override
    public void show() {
        getProxy().show();
    }

    @Override
    public void hide() {
        getProxy().hide();
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
        getProxy().setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        getProxy().setY(y);
    }

    @Override
    protected abstract UIElementProxy getProxy();

    @Override
    public void setBackground(Paint paint) {
        getProxy().setBackground(paint.getProxy());
    }

    public void setPadding(int top, int bottom, int left, int right) {
        getProxy().setPadding(top, bottom, left, right);
    }

    public void setPadding(int x, int y) {
        getProxy().setPadding(x, y);
    }

    public void setPadding(int topRightBottomLeft){
        getProxy().setPadding(topRightBottomLeft);
    }
}
