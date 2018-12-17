package com.pacgame.game.adapter;

import com.pacgame.Layer;
import com.pacgame.game.IVerticalLayer;
import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.alignment.PositionFactory;
import com.pacgame.uiElement.layer.VerticalLayer;

public class VerticalLayerAdapter extends LayerAdapter implements IVerticalLayer {
    private PositionFactory positionFactory;
    protected VerticalLayer layer;

    public VerticalLayerAdapter(LayerFactory layerFacade, PositionFactory positionFactory, int width, int height) {

        layer = layerFacade.verticalLayerBuilder().with(width, height).build();
        this.positionFactory = positionFactory;
    }

    @Override
    public void centerPosition()
    {
        layer.setAlignment(positionFactory.center());
    }

    @Override
    public Layer getProvidedObject() {
        return layer;
    }
}
