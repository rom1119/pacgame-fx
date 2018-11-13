package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.component.UIElementProvidedObject;

public class Label extends UIElementProvidedObject {

    protected LabelProxy proxy;
    protected String text;

    public Label(String text) {
        this.text = text;
        proxy = new LabelProxy();
        proxy.setText(text);
    }

    public String getText() {
        return proxy.getText();
    }
}
