package com.pacgame.provider.component.ui.button;

public class ButtonDanger extends ButtonProvidedObject {
    public ButtonDanger(String text) {
        super(text);
        proxy = new ButtonDangerProxy(text);
    }
}
