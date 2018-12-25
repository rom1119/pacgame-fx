package com.pacgame.provider.component.ui.button;

import com.pacgame.provider.alignment.PositionAlignmentProxy;
import com.pacgame.provider.color.PaintProxy;
import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import static javafx.scene.paint.Color.rgb;

public abstract class ButtonProxy extends UIElementProxy {

    protected String text;
    protected Button proxyObject;

    public ButtonProxy(String text) {
        this.text = text;
        proxyObject = new Button(this.text);
    }

    public void setAlignment(PositionAlignmentProxy positionProxy) {
        proxyObject.setAlignment(positionProxy.getProxyObject());

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
    public void setBackground(PaintProxy color) {
        proxyObject.setBackground(new Background(new BackgroundFill(color.getProxyObject(), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
