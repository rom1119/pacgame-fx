package com.pacgame.provider.component.ui.button;

import com.pacgame.provider.alignment.PositionAlignmentProxy;
import com.pacgame.provider.color.PaintProxy;
import com.pacgame.provider.component.ui.UIElementProxy;
import com.pacgame.provider.event.IEventHandlerProvider;
import com.pacgame.provider.event.type.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

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

    public void setOnAction(IEventHandlerProvider<ActionEvent> eventHandler, ActionEvent event)
    {

        getProxyObject().setOnAction(e -> {

            event.initTarget(e.getTarget().hashCode());
            event.getProxy().setProxyObject(e);
            eventHandler.handle(event);
        });
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
