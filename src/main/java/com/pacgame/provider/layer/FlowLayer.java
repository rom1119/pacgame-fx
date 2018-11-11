package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class FlowLayer extends LayerProvidedObject {

    public FlowLayer() {
        this.proxy = new FlowLayerProxy();
    }

}
