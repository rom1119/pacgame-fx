package com.pacgame.uiElement.input;

import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.UIElementProvidedObject;
import com.pacgame.uiElement.UIElement;

public class InputText extends UIInput {

    protected com.pacgame.provider.component.ui.input.InputText providedObject;

    public InputText(UIProvider provider) {
        super(provider);
        providedObject = provider.createInputText();
    }

    @Override
    protected UIElementProvidedObject getProvidedObject() {
        return providedObject;
    }
}
