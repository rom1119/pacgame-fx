package com.pacgame.uiElement.btn;

import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.UIElementProvidedObject;
import com.pacgame.provider.component.ui.button.ButtonProvidedObject;
import com.pacgame.uiElement.UIElement;

public abstract class Button extends UIElement {

    protected ButtonProvidedObject providedObject;

    public Button(UIProvider provider, String text) {
        super(provider);
    }

    @Override
    protected UIElementProvidedObject getProvidedObject() {
        return providedObject;
    }
}
