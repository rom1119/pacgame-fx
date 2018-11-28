package com.pacgame.provider.color;

import com.pacgame.provider.Paint;

public abstract class ColorProvidedObject extends Paint {

    protected ColorProxy proxy;

    @Override
    protected ColorProxy getProxy()
    {
        return proxy;
    }

    @Override
    public javafx.scene.paint.Paint getValue()
    {
        return proxy.getProxyObject();
    }
}
