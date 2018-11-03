package com.pacgame.provider.proxy.layer;

import com.pacgame.provider.proxy.LayerProxy;
import javafx.scene.Group;

public class GroupLayerProxy extends LayerProxy {

    protected Group layer;

    public GroupLayerProxy() {
        super();
        layer = new Group();
    }
}
