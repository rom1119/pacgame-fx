package com.pacgame.provider;

import com.pacgame.provider.color.PaintProxy;

public abstract class Paint extends ProvidedObject {
    protected PaintProxy proxy;

    public PaintProxy getProxy()
    {
        return proxy;
    }
}
