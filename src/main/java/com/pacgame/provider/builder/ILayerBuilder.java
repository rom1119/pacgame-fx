package com.pacgame.provider.builder;

import com.pacgame.IBuilder;
import com.pacgame.provider.layer.Layer;

public interface ILayerBuilder<T extends Layer> extends IBuilder<T> {


    ILayerBuilder create();
    ILayerBuilder with(int width, int height);

}
