package com.pacgame.game.adapter.factory;

import com.pacgame.game.ILayer;
import com.pacgame.game.ILayoutFactory;
import com.pacgame.game.IVerticalLayer;
import com.pacgame.game.adapter.FlowLayerAdapter;
import com.pacgame.game.adapter.GroupLayerAdapter;
import com.pacgame.game.adapter.VerticalLayerAdapter;
import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.UIFactory;
import com.pacgame.uiElement.alignment.PositionFactory;

public class LayoutFactoryAdapter implements ILayoutFactory {

    private UIFactory uiFacade;
    private LayerFactory layerFacade;
    private PositionFactory positionFactory;

    public LayoutFactoryAdapter(UIFactory uiFacade, LayerFactory layerFacade, PositionFactory positionFactory) {
        this.uiFacade = uiFacade;
        this.layerFacade = layerFacade;
        this.positionFactory = positionFactory;
    }

    @Override
    public ILayer createGroupLayer(int width, int height) {
        return new GroupLayerAdapter(layerFacade, width, height);
    }

    @Override
    public ILayer createFlowLayer(int width, int height) {
        return new FlowLayerAdapter(layerFacade, width, height);
    }

    @Override
    public IVerticalLayer createVerticalLayer(int width, int height) {
        return new VerticalLayerAdapter(layerFacade, positionFactory, width, height);
    }

    @Override
    public IVerticalLayer createCenteredVerticalLayer(int width, int height) {
        IVerticalLayer verticalLayer = createVerticalLayer(width, height);
        verticalLayer.centerPosition();
        return verticalLayer;
    }
}
