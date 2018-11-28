package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class GroupLayer extends LayerProvidedObject {

//    protected GroupLayerProxy proxy;

    public GroupLayer() {
        super();
        this.proxy = new GroupLayerProxy();
    }

}
