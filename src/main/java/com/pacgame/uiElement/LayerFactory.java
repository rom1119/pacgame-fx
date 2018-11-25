package com.pacgame.uiElement;

import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.LayerProvider;
import com.pacgame.uiElement.layer.FlowLayerBuilder;
import com.pacgame.uiElement.layer.GroupLayerBuilder;
import com.pacgame.uiElement.layer.VerticalLayerBuilder;

public class LayerFactory {

    private LayerProvider layerProvider;

    public LayerFactory(LayerProvider layerProvider) {
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
