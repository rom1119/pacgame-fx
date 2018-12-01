package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

class LabelProxy extends UIElementProxy {

    protected Label proxyObject;

    public LabelProxy() {
        proxyObject = new Label();
    }

    @Override
    public Label getProxyObject() {
        return proxyObject;
    }

    @Override
    public void setBackground(Paint color) {
        proxyObject.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public String getText() {

        return proxyObject.getText();
    }

    public void setText(String text) {
        this.proxyObject.setText(text);
    }
}
