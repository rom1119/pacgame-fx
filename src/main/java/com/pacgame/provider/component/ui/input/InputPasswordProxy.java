package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.alignment.PositionAlignmentProxy;
import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;

public class InputPasswordProxy extends UIElementProxy {

    protected PasswordField proxyObject;

    public InputPasswordProxy() {
        proxyObject = new PasswordField();
    }

    public void setAlignment(PositionAlignmentProxy positionProxy) {
        proxyObject.setAlignment(positionProxy.getProxyObject());

    }

    @Override
    public Control getProxyObject() {
        return proxyObject;
    }
}
