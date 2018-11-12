package com.pacgame.uiElement.btn;

import com.pacgame.provider.component.ui.button.ButtonProvidedObject;
import com.pacgame.uiElement.UIElement;

public abstract class Button extends UIElement {

    protected ButtonProvidedObject providedObject;

    public Button(int width, int height) {
        super(width, height);
    }
}
