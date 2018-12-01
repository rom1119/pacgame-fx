package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;

public class InputPasswordProxy extends UIElementProxy {

    protected PasswordField proxyObject;

    public InputPasswordProxy() {
        proxyObject = new PasswordField();
    }

    @Override
    public Control getProxyObject() {
        return proxyObject;
    }
}
