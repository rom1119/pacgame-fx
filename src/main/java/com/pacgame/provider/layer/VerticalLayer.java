package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class VerticalLayer extends LayerProvidedObject {

    public VerticalLayer() {
        this.proxy = new VerticalLayerProxy();
    }
}
