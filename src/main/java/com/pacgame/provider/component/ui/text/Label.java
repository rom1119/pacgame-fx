package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.component.UIElementProvidedObject;

public class Label extends UIElementProvidedObject {

    protected LabelProxy proxy;

    public Label(LabelProxy proxy) {
        this.proxy = proxy;
    }

    public String getText() {
        return proxy.getText();
    }
}
