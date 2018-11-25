package com.pacgame.game.adapter;

import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.layer.GroupLayer;

public class GroupLayerAdapter extends LayerAdapter {

    public GroupLayerAdapter(LayerFactory layerFacade) {

        layer = layerFacade.groupLayerBuilder().with(200, 200).build();
    }




}
