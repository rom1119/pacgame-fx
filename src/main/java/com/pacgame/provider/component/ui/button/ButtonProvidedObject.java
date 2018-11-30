package com.pacgame.provider.component.ui.button;

import com.pacgame.provider.Paint;
import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.component.UIElementProvidedObject;

public abstract class ButtonProvidedObject extends UIElementProvidedObject {

    protected ButtonProxy proxy;

    public ButtonProvidedObject(String text) {
    }

    public String getText() {

        return proxy.getText();
    }

    public void setText(String text) {
        this.proxy.setText(text);
    }

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
    protected ButtonProxy getProxy() {
        return proxy;
    }

    @Override
    public void setBorder(Paint paint, int width) {
        proxy.setBorder(paint.getValue(), width);
    }
}
