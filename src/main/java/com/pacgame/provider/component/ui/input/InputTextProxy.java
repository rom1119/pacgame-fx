package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.alignment.PositionAlignmentProxy;
import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class InputTextProxy extends UIElementProxy {

    protected TextField proxyObject;

    public InputTextProxy() {
        proxyObject = new TextField();
    }

    public void setAlignment(PositionAlignmentProxy positionProxy) {
        proxyObject.setAlignment(positionProxy.getProxyObject());

    }

    @Override
    public Control getProxyObject() {
        return proxyObject;
    }
}
