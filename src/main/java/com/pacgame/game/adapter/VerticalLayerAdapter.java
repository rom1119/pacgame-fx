package com.pacgame.game.adapter;

import com.pacgame.uiElement.LayerFactory;

public class VerticalLayerAdapter extends LayerAdapter {

    public VerticalLayerAdapter(LayerFactory layerFacade, int width, int height) {

        layer = layerFacade.verticalLayerBuilder().with(width, height).build();
    }
}
