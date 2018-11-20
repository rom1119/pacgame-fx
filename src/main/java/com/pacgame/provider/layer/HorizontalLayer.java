package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class HorizontalLayer extends LayerProvidedObject {

    public HorizontalLayer() {
        proxy = new HorizontalLayerProxy();
    }
}
