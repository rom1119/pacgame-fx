package com.pacgame.game.adapter;

import com.pacgame.Layer;
import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.layer.FlowLayer;

public class FlowLayerAdapter extends LayerAdapter {

    protected FlowLayer layer;

    public FlowLayerAdapter(LayerFactory layerFacade, int width, int height) {

        layer = layerFacade.flowLayerBuilder().with(width, height).build();
    }

    @Override
    public Layer getProvidedObject() {
        return layer;
    }


}
