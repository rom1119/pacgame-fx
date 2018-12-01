package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProxy;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

class HorizontalLayerProxy extends LayerProxy {

    protected HBox proxyObject;
    public HorizontalLayerProxy() {
        super();
        proxyObject = new HBox();
    }

    @Override
    public HBox getProxyObject() {
        return proxyObject;
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
            children.remove(el.hashCode());
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

}
