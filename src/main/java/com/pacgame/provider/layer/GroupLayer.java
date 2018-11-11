package com.pacgame.provider.layer;

import com.pacgame.provider.LayerProvidedObject;

public class GroupLayer extends LayerProvidedObject {

    public GroupLayer() {
        this.proxy = new GroupLayerProxy();
    }


    @Override
    public void setWidth(int width) {
        this.width = width;
        proxy.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        proxy.setHeight(height);
    }
}
