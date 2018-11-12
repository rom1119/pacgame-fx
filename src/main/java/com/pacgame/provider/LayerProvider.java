package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayerBuilder;
import com.pacgame.provider.layer.GroupLayerBuilder;
import com.pacgame.provider.layer.ILayerBuilder;
import com.pacgame.provider.layer.VerticalLayerBuilder;

public class LayerProvider implements ILayerProvider {

    @Override
    public FlowLayerBuilder flowLayerBuilder() {
        return new FlowLayerBuilder();
    }

    @Override
    public GroupLayerBuilder groupLayerBuilder() {
        return new GroupLayerBuilder();
    }

    @Override
    public VerticalLayerBuilder verticalLayerBuilder() {
        return new VerticalLayerBuilder();
    }
}
