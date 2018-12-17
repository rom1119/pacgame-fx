package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.alignment.PositionAlignmentProxy;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class VerticalLayerProxy extends LayerProxy {

    protected VBox proxyObject;

    public VerticalLayerProxy() {
        super();
        proxyObject = new VBox();
    }

    public void setAlignment(PositionAlignmentProxy positionProxy) {
        proxyObject.setAlignment(positionProxy.getProxyObject());

    }

    @Override
    public VBox getProxyObject() {
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
}
