package com.pacgame.provider.proxy.ui.text;

import com.pacgame.provider.proxy.ComponentProxy;
import com.pacgame.provider.proxy.ui.UIElementProxy;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class LabelProxy extends UIElementProxy {

    protected Label proxyObject;

    @Override
    public Label getProxyObject() {
        return proxyObject;
    }
}
