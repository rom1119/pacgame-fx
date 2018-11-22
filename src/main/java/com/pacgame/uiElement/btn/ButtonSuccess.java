package com.pacgame.uiElement.btn;

import com.pacgame.provider.UIProvider;

public class ButtonSuccess extends Button {

    public ButtonSuccess(UIProvider provider, String text) {
        super(provider, text);
        this.providedObject = provider.createButtonSuccess(text);
    }
}
