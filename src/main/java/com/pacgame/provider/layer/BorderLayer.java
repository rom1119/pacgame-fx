package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class BorderLayer extends LayerProvidedObject {

    public BorderLayer() {
        this.proxy = new BorderLayerProxy();
    }
}
