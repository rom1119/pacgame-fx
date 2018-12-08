package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.alignment.PositionAlignment;

public class HorizontalLayer extends LayerProvidedObject {

    protected HorizontalLayerProxy proxy;

    public HorizontalLayer() {
        proxy = new HorizontalLayerProxy();
    }

    @Override
    public LayerProxy getProxy() {
        return proxy;
    }

    public void setAlignment(PositionAlignment positionAlignment) {
        proxy.setAlignment(positionAlignment.getProxy());

    }
}
