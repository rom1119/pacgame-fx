package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.color.Red;
import com.pacgame.provider.layer.LayerProxy;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

class GroupLayerProxy extends LayerProxy {

    protected Group proxyObject;
    private Pane pane;

    public GroupLayerProxy() {
        super();
        proxyObject = new Group();
        pane = new Pane();
        proxyObject.getChildren().add(pane);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        getProxyObject().prefWidth(width);
        pane.setPrefWidth(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        getProxyObject().prefHeight(height);
        pane.setPrefHeight(height);
    }

    @Override
    public Group getProxyObject() {
        return proxyObject;
    }

    @Override
    public void addChildren(ViewProxy el) {
//        ((VerticalLayerProxy)el).getProxyObject().setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
//        ((VerticalLayerProxy)el).proxyObject.setPrefWidth(100);
//        ((VerticalLayerProxy)el).proxyObject.setPrefHeight(100);
        if (!hasChildren(el)) {
        System.out.println(el);
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
    public void setBackground(Paint color) {
        this.paint = color;
        pane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void setPadding(int top, int right, int bottom, int left)
    {
        pane.setPadding(new Insets(top, right, bottom, left));
    }

    @Override
    public void setPadding(int x, int y)
    {
        pane.setPadding(new Insets(y, x, y, x));
    }

    @Override
    public void setPadding(int topRightBottomLeft)
    {
        pane.setPadding(new Insets(topRightBottomLeft));
    }

}
