package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.alignment.PositionAlignment;

public class VerticalLayer extends LayerProvidedObject {

    protected VerticalLayerProxy proxy;

    public VerticalLayer() {
        this.proxy = new VerticalLayerProxy();
    }

    @Override
    public LayerProxy getProxy() {
        return proxy;
    }

    public void setAlignment(PositionAlignment positionAlignment) {
        proxy.setAlignment(positionAlignment.getProxy());

    }

}
