package com.pacgame.provider.layer;

import com.pacgame.provider.layer.LayerProxy;
import javafx.scene.Group;

public class GroupLayerProxy extends LayerProxy {

    protected Group layer;

    public GroupLayerProxy() {
        super();
        layer = new Group();
    }
}
