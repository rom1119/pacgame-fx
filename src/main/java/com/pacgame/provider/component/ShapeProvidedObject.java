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

    public boolean intersects(ShapeProvidedObject el)
    {
        return getProxy().intersects(el.getProxy());
    }

    public int intersectWidth(ShapeProvidedObject el)
    {
        return getProxy().intersectWidth(el.getProxy());
    }

    public int intersectHeight(ShapeProvidedObject el)
    {
        return getProxy().intersectHeight(el.getProxy());
    }

    public abstract void setWidth(int val);

    public abstract int getWidth();

    public abstract void setHeight(int val);

    public abstract int getHeight();
}
