package com.pacgame.game.adapter;

import com.pacgame.uiElement.LayerFactory;

public class FlowLayerAdapter extends LayerAdapter {

    public FlowLayerAdapter(LayerFactory layerFacade, int width, int height) {

        layer = layerFacade.flowLayerBuilder().with(width, height).build();
    }
}
