package com.pacgame.provider.layer;

import com.pacgame.provider.layer.LayerProxy;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class GroupLayerProxy extends LayerProxy {


    public GroupLayerProxy() {
        super();
        proxyObject = new Group();
    }

}
