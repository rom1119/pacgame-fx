package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class VerticalLayer extends LayerProvidedObject {

    protected VerticalLayerProxy proxy;

    public VerticalLayer() {
        this.proxy = new VerticalLayerProxy();
    }

    @Override
    public LayerProxy getProxy() {
        return proxy;
    }

}
