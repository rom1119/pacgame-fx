package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class GroupLayer extends LayerProvidedObject {

//    protected GroupLayerProxy proxy;

    public GroupLayer() {
        super();
        this.proxy = new GroupLayerProxy();
    }

//    @Override
//    public GroupLayerProxy getProxy() {
//        return proxy;
//    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        proxy.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        proxy.setHeight(height);
    }
}
