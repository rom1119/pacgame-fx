package com.pacgame.provider;

import com.pacgame.provider.layer.ILayerBuilder;

public class LayerProvider<T extends LayerProvidedObject> implements ILayerProvider {

    @Override
    public ILayerBuilder Builder() {
        return null;
    }
}
