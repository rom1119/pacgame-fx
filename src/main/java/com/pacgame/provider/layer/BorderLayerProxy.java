package com.pacgame.provider.layer;

import com.pacgame.provider.IProxy;
import javafx.scene.layout.BorderPane;

public class BorderLayerProxy extends LayerProxy {

    protected BorderPane layer;

    public BorderLayerProxy() {
        super();
        layer = new BorderPane();
    }
}
