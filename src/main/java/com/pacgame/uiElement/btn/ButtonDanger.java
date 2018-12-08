package com.pacgame.uiElement.btn;

import com.pacgame.provider.UIProvider;

public class ButtonDanger extends Button {
    public ButtonDanger(UIProvider provider, String text) {
        super(provider, text);
        providedObject = provider.createButtonDanger(text);
    }
}
