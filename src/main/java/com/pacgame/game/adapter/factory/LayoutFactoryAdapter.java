package com.pacgame.game.adapter.factory;

import com.pacgame.game.ILayer;
import com.pacgame.game.ILayoutFactory;
import com.pacgame.game.adapter.FlowLayerAdapter;
import com.pacgame.game.adapter.GroupLayerAdapter;
import com.pacgame.game.adapter.VerticalLayerAdapter;
import com.pacgame.uiElement.LayerFactory;
import com.pacgame.uiElement.UIFactory;

public class LayoutFactoryAdapter implements ILayoutFactory {

    private UIFactory uiFacade;
    private LayerFactory layerFacade;

    public LayoutFactoryAdapter(UIFactory uiFacade, LayerFactory layerFacade) {
        this.uiFacade = uiFacade;
        this.layerFacade = layerFacade;
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
    public ILayer createVerticalLayer(int width, int height) {
        return new VerticalLayerAdapter(layerFacade, width, height);
    }
}
