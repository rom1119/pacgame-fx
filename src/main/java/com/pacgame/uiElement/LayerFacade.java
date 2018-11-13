package com.pacgame.uiElement;

import com.pacgame.provider.ILayerProvider;
import com.pacgame.uiElement.layer.FlowLayerBuilder;
import com.pacgame.uiElement.layer.GroupLayerBuilder;
import com.pacgame.uiElement.layer.VerticalLayerBuilder;

public class LayerFacade {

    private ILayerProvider layerProvider;

    public LayerFacade(ILayerProvider layerProvider) {
        this.layerProvider = layerProvider;
    }

    public FlowLayerBuilder flowLayerBuilder()
    {
        return new FlowLayerBuilder(layerProvider);
    }

    public GroupLayerBuilder groupLayerBuilder()
    {
        return new GroupLayerBuilder(layerProvider);
    }

    public VerticalLayerBuilder verticalLayerBuilder()
    {
        return new VerticalLayerBuilder(layerProvider);
    }
}
