package com.pacgame.provider.component.ui.button;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ButtonDangerProxy extends ButtonProxy {
    public ButtonDangerProxy(String name) {
        super(name);
        proxyObject.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        getProxyObject().setTextFill(Color.BLACK);

    }
}
