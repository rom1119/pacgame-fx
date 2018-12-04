package com.pacgame.provider.color;

import com.pacgame.provider.Paint;
import com.pacgame.provider.Proxy;
import javafx.scene.paint.Color;

public abstract class ColorProxy extends PaintProxy {

    protected Color proxyObject;

    public Color getProxyObject()
    {
        return proxyObject;
    }

}
