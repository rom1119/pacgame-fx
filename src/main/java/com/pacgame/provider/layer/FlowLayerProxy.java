package com.pacgame.provider.layer;

import com.pacgame.provider.layer.LayerProxy;
import javafx.scene.layout.FlowPane;

public class FlowLayerProxy extends LayerProxy {

    public FlowLayerProxy() {
        super();
        proxyObject = new FlowPane();
    }
}
