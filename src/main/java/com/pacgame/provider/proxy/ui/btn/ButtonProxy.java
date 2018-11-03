package com.pacgame.provider.proxy.ui.btn;

import com.pacgame.provider.proxy.ui.UIElementProxy;
import javafx.scene.control.Button;

public abstract class ButtonProxy extends UIElementProxy {

    protected String name;
    protected Button proxyObject;

    public ButtonProxy(String name) {
        this.name = name;
        proxyObject = new Button(this.name);
    }

    @Override
    public Button getProxyObject() {
        return proxyObject;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
