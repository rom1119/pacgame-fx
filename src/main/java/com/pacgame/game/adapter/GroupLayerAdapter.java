package com.pacgame.game.adapter;

import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.layer.GroupLayer;

public class GroupLayerAdapter extends LayerAdapter {

    public GroupLayerAdapter(LayerFactory layerFacade, int width, int height) {

        layer = layerFacade.groupLayerBuilder().with(width, height).build();
    }




}
