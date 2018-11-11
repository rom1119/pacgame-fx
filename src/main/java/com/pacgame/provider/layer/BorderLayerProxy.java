package com.pacgame.provider.layer;

import com.pacgame.provider.layer.LayerProxy;
import javafx.scene.layout.BorderPane;

public class BorderLayerProxy extends LayerProxy {

    protected BorderPane proxyObject;

    public BorderLayerProxy() {
        super();
        proxyObject = new BorderPane();
    }
}
