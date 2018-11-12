package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayerBuilder;
import com.pacgame.provider.layer.GroupLayerBuilder;
import com.pacgame.provider.layer.ILayerBuilder;

public interface ILayerProvider extends IProvider {

    FlowLayerBuilder flowLayerBuilder();
    GroupLayerBuilder groupLayerBuilder();



}
