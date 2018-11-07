package com.pacgame.provider.component.ui.button;

import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.scene.control.Button;

public abstract class ButtonProxy extends UIElementProxy {

    protected String name;
    protected Button proxyObject;

    public ButtonProxy(String name) {
        this.name = name;
        proxyObject = new Button(this.name);
    }

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
