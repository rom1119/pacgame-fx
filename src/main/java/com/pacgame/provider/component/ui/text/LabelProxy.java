package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

class LabelProxy extends UIElementProxy {

    protected javafx.scene.control.Label proxyObject;

    public LabelProxy() {
        proxyObject = new javafx.scene.control.Label();
    }

    @Override
    public javafx.scene.control.Label getProxyObject() {
        return proxyObject;
    }

    @Override
    public void setBackground(Paint color) {
        getProxyObject().setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public String getText() {

        return getProxyObject().getText();
    }

    public void setText(String text) {
        getProxyObject().setText(text);
    }
}
