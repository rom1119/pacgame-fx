package com.pacgame.provider.layer;

import com.pacgame.provider.layer.LayerProxy;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class GroupLayerProxy extends LayerProxy {

    protected Group proxyObject;

    public GroupLayerProxy() {
        super();
        proxyObject = new Group();
    }

    @Override
    public Group getProxyObject() {
        return proxyObject;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }
}
