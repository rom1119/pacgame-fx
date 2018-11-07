package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.component.UIElementProvidedObject;

class Label extends UIElementProvidedObject {

    protected String textElement;

    public Label(String textElement) {
        this.textElement = textElement;
    }

    public String getTextElement() {
        return textElement;
    }
}
