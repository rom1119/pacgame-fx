package com.pacgame.provider.color;

import com.pacgame.provider.Paint;

public abstract class ColorProvidedObject extends Paint {

    protected ColorProxy proxy;

    @Override
    public ColorProxy getProxy(){
        return proxy;
    }

}
