package com.pacgame.game.adapter;

import com.pacgame.game.ILayer;
import com.pacgame.game.ILayoutFactory;
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
    public ILayer createGroupLayer() {
        return new GroupLayerAdapter(layerFacade);
    }
}
