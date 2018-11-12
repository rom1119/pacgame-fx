package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayerBuilder;
import com.pacgame.provider.layer.GroupLayerBuilder;
import com.pacgame.provider.layer.ILayerBuilder;

public class LayerProvider<T extends LayerProvidedObject> implements ILayerProvider {

    @Override
    public FlowLayerBuilder flowLayerBuilder() {
        return new FlowLayerBuilder();
    }

    @Override
    public GroupLayerBuilder groupLayerBuilder() {
        return new GroupLayerBuilder();
    }
}
