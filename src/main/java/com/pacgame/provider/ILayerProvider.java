package com.pacgame.provider;

import com.pacgame.provider.builder.ILayerBuilder;

public interface ILayerProvider extends IProvider {

    ILayerBuilder Builder();
}
