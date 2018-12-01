package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;

public class InputCheckboxProxy extends UIElementProxy {

    protected CheckBox proxyObject;

    public InputCheckboxProxy() {
        proxyObject = new CheckBox();
    }

    @Override
    public Control getProxyObject() {
        return proxyObject;
    }
}
