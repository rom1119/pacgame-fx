package com.pacgame.provider.proxy.ui.btn;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ButtonSuccessProxy extends ButtonProxy {
    public ButtonSuccessProxy(String name) {
        super(name);
        getProxyObject().setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        getProxyObject().setTextFill(Color.BLACK);
        getProxyObject().setTextFill(Color.BLACK);

    }
}
