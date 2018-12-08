package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.alignment.PositionAlignment;

public class FlowLayer extends LayerProvidedObject {

    private FlowLayerProxy proxy;

    public FlowLayer() {
        this.proxy = new FlowLayerProxy();
    }

    @Override
    public LayerProxy getProxy() {
        return proxy;
    }

    public void setAlignment(PositionAlignment positionAlignment) {
        proxy.setAlignment(positionAlignment.getProxy());

    }

}
