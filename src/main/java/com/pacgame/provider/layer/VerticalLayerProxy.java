package com.pacgame.provider.layer;

import javafx.scene.layout.VBox;

public class VerticalLayerProxy extends LayerProxy {

    protected VBox proxyObject;

    public VerticalLayerProxy() {
        super();
        proxyObject = new VBox();
    }
}
