package com.pacgame.provider.component.ui.button;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ButtonSuccessProxy extends ButtonProxy {
    public ButtonSuccessProxy(String name) {
        super(name);
        proxyObject.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        getProxyObject().setTextFill(Color.BLACK);

    }
}
