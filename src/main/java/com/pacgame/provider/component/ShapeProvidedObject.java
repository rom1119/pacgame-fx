package com.pacgame.provider.component;

import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.component.shape.ShapeProxy;

public abstract class ShapeProvidedObject extends ComponentProvidedObject {

    @Override
    protected abstract ShapeProxy getProxy();

    public void setRotate(int val)
    {
        getProxy().setRotate(val);
    }

    public int getRotate()
    {
        return getProxy().getRotate();
    }
}
