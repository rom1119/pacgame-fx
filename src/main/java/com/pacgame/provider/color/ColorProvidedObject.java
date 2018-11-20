package com.pacgame.provider.color;

import com.pacgame.provider.ProvidedObject;

public abstract class ColorProvidedObject extends Paint {

    protected ColorProxy proxy;

    public ColorProxy getProxy()
    {
        return proxy;
    }
}
