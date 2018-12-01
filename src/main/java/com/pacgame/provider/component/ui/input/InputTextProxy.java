package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class InputTextProxy extends UIElementProxy {

    protected TextField proxyObject;

    public InputTextProxy() {
        proxyObject = new TextField();
    }


    @Override
    public Control getProxyObject() {
        return proxyObject;
    }
}
