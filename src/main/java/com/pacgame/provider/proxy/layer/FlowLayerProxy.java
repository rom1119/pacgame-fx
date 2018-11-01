package com.pacgame.provider.proxy.layer;

import com.pacgame.provider.proxy.LayerProxy;
import javafx.scene.layout.FlowPane;

public class FlowLayerProxy extends LayerProxy {

    protected FlowPane layer;

    public FlowLayerProxy() {
        super();
        layer = new FlowPane();
    }
}
