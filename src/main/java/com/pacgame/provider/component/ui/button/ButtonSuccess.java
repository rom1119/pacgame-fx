package com.pacgame.provider.component.ui.button;

public class ButtonSuccess extends ButtonProvidedObject {
    public ButtonSuccess(String text) {
        super(text);
        proxy = new ButtonSuccessProxy(text);
    }
}
