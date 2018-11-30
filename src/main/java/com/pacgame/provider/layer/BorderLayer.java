package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.Paint;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.property.PropertyProvider;

public class BorderLayer extends LayerProvidedObject {

    protected BorderLayerProxy proxy;

    public BorderLayer() {
        this.proxy = new BorderLayerProxy();
    }

    @Override
    public LayerProxy getProxy() {
        return proxy;
    }

}
