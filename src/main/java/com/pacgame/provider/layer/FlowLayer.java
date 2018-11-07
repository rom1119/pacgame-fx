package com.pacgame.provider.layer;

public class FlowLayer extends LayerProvidedObject {

    public FlowLayer() {
        this.proxy = new FlowLayerProxy();
    }
}
