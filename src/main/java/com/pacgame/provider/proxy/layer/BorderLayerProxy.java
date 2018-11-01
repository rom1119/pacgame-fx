package com.pacgame.provider.proxy.layer;

import com.pacgame.provider.proxy.LayerProxy;
import javafx.scene.layout.BorderPane;

public class BorderLayerProxy extends LayerProxy {

    protected BorderPane layer;

    public BorderLayerProxy() {
        super();
        layer = new BorderPane();
    }
}
