package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.alignment.PositionAlignment;
import com.pacgame.provider.alignment.PositionAlignmentProxy;
import com.pacgame.provider.color.PaintProxy;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;

class FlowLayerProxy extends LayerProxy {

    protected FlowPane proxyObject;

    public FlowLayerProxy() {
        super();
        proxyObject = new FlowPane();
    }

    @Override
    public FlowPane getProxyObject() {
        return proxyObject;
    }

    public void setAlignment(PositionAlignmentProxy positionProxy) {
        proxyObject.setAlignment(positionProxy.getProxyObject());

    }

    @Override
    public void addChildren(ViewProxy el) {
        if (!hasChildren(el)) {
            children.put(String.valueOf(el.hashCode()), el);
            getProxyObject().getChildren().add(el.getProxyObject());
        }
    }

    @Override
    public void removeChildren(ViewProxy el) {
        if (hasChildren(el)) {
            children.remove(String.valueOf(el.hashCode()));
            getProxyObject().getChildren().remove(el.getProxyObject());
        }
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        getProxyObject().setPrefWidth(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        getProxyObject().setPrefHeight(height);

    }

    @Override
    public void setBackground(PaintProxy color) {
        getProxyObject().setBackground(new Background(new BackgroundFill(color.getProxyObject(), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
