package com.pacgame.provider.ui.text;

import com.pacgame.provider.ui.UIElementProvidedObject;

public class Label extends UIElementProvidedObject {

    protected String textElement;

    public Label(String textElement) {
        this.textElement = textElement;
    }

    public String getTextElement() {
        return textElement;
    }
}
