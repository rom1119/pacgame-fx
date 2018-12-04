package com.pacgame.provider.color;

import com.pacgame.provider.Proxy;
import javafx.scene.paint.Paint;

public abstract class PaintProxy extends Proxy {

    protected Paint proxyObject;

    public Paint getProxyObject()
    {
        return proxyObject;

    }
}
