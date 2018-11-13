package com.pacgame.provider.component.ui.button;

import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import static javafx.scene.paint.Color.rgb;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.WHITE;

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
    public void fill(int red, int green, int blue, double alpha) {
        proxyObject.setBackground(new Background(new BackgroundFill(rgb(red, green, blue, alpha), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void fill(int red, int green, int blue) {
        proxyObject.setBackground(new Background(new BackgroundFill(rgb(red, green, blue), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void fillRed() {
        proxyObject.setBackground(new Background(new BackgroundFill(RED, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void fillBlue() {
        proxyObject.setBackground(new Background(new BackgroundFill(BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void fillGreen() {
        proxyObject.setBackground(new Background(new BackgroundFill(GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void fillWhite() {
        proxyObject.setBackground(new Background(new BackgroundFill(WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void setColor(com.pacgame.provider.color.Color color) {
        proxyObject.setBackground(new Background(new BackgroundFill(color.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
