package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class FlowLayer extends LayerProvidedObject {

    protected FlowLayerProxy proxy;

    public FlowLayer() {
        this.proxy = new FlowLayerProxy();
    }

    @Override
    public LayerProxy getProxy() {
        return proxy;
    }

}
