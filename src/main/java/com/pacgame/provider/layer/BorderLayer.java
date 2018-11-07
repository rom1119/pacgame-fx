package com.pacgame.provider.layer;

public class BorderLayer extends LayerProvidedObject {

    public BorderLayer() {
        this.proxy = new BorderLayerProxy();
    }
}
