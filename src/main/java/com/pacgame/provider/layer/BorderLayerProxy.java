package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.layer.LayerProxy;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class BorderLayerProxy extends LayerProxy {

    protected BorderPane proxyObject;

    public BorderLayerProxy() {
        super();
        proxyObject = new BorderPane();
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


    @Override
    public void addChildren(ViewProxy el) {
        if (!hasChildren(el)) {
            children.put(String.valueOf(el.hashCode()), el);
            proxyObject.getChildren().add(el.getProxyObject());
        }
    }

    @Override
    public void removeChildren(ViewProxy el) {
        if (hasChildren(el)) {
            children.remove(el.hashCode());
            proxyObject.getChildren().remove(el.getProxyObject());

        }
    }

    @Override
    public boolean isVisible() {
        return super.isVisible();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void setBackground(Paint color) {
        proxyObject.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
