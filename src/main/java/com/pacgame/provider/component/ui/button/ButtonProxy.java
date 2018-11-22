package com.pacgame.provider.component.ui.button;

import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

import static javafx.scene.paint.Color.rgb;

public abstract class ButtonProxy extends UIElementProxy {

    protected String text;
    protected Button proxyObject;

    public ButtonProxy(String text) {
        this.text = text;
        proxyObject = new Button(this.text);
    }

    public Button getProxyObject() {
        return proxyObject;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setWidth(int width)
    {
        proxyObject.setPrefWidth(width);
    }

    public void setHeight(int height)
    {
        proxyObject.setPrefHeight(height);
    }

    @Override
    public void setBackground(Paint color) {
        proxyObject.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
