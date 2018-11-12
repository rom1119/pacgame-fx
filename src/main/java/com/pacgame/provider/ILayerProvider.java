package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayerBuilder;
import com.pacgame.provider.layer.GroupLayerBuilder;
import com.pacgame.provider.layer.ILayerBuilder;
import com.pacgame.provider.layer.VerticalLayerBuilder;

public interface ILayerProvider extends IProvider {

    FlowLayerBuilder flowLayerBuilder();
    GroupLayerBuilder groupLayerBuilder();
    VerticalLayerBuilder verticalLayerBuilder();



}
