package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.alignment.PositionAlignmentProxy;
import com.pacgame.provider.color.PaintProxy;
import javafx.geometry.Insets;
import javafx.scene.layout.*;

class BorderLayerProxy extends LayerProxy {

    protected BorderPane proxyObject;

    public BorderLayerProxy() {
        super();
        proxyObject = new BorderPane();
    }

    public void setAlignment(ViewProxy el, PositionAlignmentProxy position) {
        getProxyObject().setAlignment(el.getProxyObject(), position.getProxyObject());

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
    public void setBackground(PaintProxy color) {
        getProxyObject().setBackground(new Background(new BackgroundFill(color.getProxyObject(), CornerRadii.EMPTY, Insets.EMPTY)));
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
    public BorderPane getProxyObject() {
        return proxyObject;
    }

    public void setTop(ViewProxy el)
    {
        proxyObject.setTop(el.getProxyObject());
    }

    public void setBottom(ViewProxy el)
    {
        proxyObject.setBottom(el.getProxyObject());
    }

    public void setCenter(ViewProxy el)
    {
        proxyObject.setCenter(el.getProxyObject());
    }

    public void setLeft(ViewProxy el)
    {
        proxyObject.setLeft(el.getProxyObject());
    }

    public void setRight(ViewProxy el)
    {
        proxyObject.setRight(el.getProxyObject());
    }


}
