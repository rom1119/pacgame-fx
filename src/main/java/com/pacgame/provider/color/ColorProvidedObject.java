package com.pacgame.provider.color;

import com.pacgame.provider.ProvidedObject;

public abstract class ColorProvidedObject extends ProvidedObject {

    protected ColorProxy proxy;

    public ColorProxy getProxy()
    {
        return proxy;
    }
}
