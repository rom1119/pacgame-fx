package com.pacgame.provider;

import com.pacgame.provider.builder.ILayerBuilder;

public interface ILayerProvider extends IProvider {

    @Override
    LayerProvidedObject provide();

    ILayerBuilder Builder();



}
