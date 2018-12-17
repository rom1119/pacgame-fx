package com.pacgame.game.adapter;

import com.pacgame.Layer;
import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.layer.GroupLayer;

public class GroupLayerAdapter extends LayerAdapter {

    protected GroupLayer layer;

    public GroupLayerAdapter(LayerFactory layerFacade, int width, int height) {

        layer = layerFacade.groupLayerBuilder().with(width, height).build();
    }


    @Override
    public Layer getProvidedObject() {
        return layer;
    }
}
