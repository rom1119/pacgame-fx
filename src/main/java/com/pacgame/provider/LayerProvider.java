package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayerBuilder;
import com.pacgame.provider.layer.GroupLayerBuilder;
import com.pacgame.provider.layer.VerticalLayerBuilder;

public abstract class LayerProvider extends Provider {

    public abstract FlowLayerBuilder flowLayerBuilder();
    public abstract GroupLayerBuilder groupLayerBuilder();
    public abstract VerticalLayerBuilder verticalLayerBuilder();



}
