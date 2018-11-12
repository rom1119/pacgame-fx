package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class GroupLayer extends LayerProvidedObject {

    public GroupLayer() {
        this.proxy = new GroupLayerProxy();
    }

}
