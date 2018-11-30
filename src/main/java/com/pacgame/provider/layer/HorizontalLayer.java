package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class HorizontalLayer extends LayerProvidedObject {

    protected HorizontalLayerProxy proxy;

    public HorizontalLayer() {
        proxy = new HorizontalLayerProxy();
    }

    @Override
    public LayerProxy getProxy() {
        return proxy;
    }
}
