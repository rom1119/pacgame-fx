package com.pacgame.provider.layer;

import com.pacgame.provider.IProxy;
import javafx.scene.layout.FlowPane;

public class FlowLayerProxy extends LayerProxy {

    protected FlowPane layer;

    public FlowLayerProxy() {
        super();
        layer = new FlowPane();
    }
}
