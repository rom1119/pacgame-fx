package com.pacgame.provider.builder;

import com.pacgame.provider.layer.FlowLayer;
import com.pacgame.provider.layer.Layer;

public class FlowLayerBuilder implements ILayerBuilder<FlowLayer> {



    @Override
    public FlowLayer build() {
        FlowLayer t = new FlowLayer();

        return t;
    }

    @Override
    public ILayerBuilder create() {
        return null;
    }

    @Override
    public ILayerBuilder with(int width, int height) {
        return null;
    }
}
