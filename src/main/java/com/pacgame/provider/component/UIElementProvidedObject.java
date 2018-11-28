package com.pacgame.provider.component;


import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.Paint;
import com.pacgame.provider.component.ui.UIElementProxy;

public abstract class UIElementProvidedObject extends ComponentProvidedObject {

    protected UIElementProxy proxy;

    public void setBorder(Paint paint, int width)
    {
        proxy.setBorder(paint.getValue(), width);
    }

}
