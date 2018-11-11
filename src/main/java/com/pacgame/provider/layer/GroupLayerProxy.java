package com.pacgame.provider.layer;

import com.pacgame.provider.layer.LayerProxy;
import javafx.scene.Group;

public class GroupLayerProxy extends LayerProxy {

    protected Group proxyObject;

    public GroupLayerProxy() {
        super();
        proxyObject = new Group();
    }
}
