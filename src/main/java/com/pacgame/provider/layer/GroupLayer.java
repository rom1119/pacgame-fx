package com.pacgame.provider.layer;

public class GroupLayer extends LayerProvidedObject {

    public GroupLayer() {
        this.proxy = new GroupLayerProxy();
    }
}
