package com.pacgame.uiElement.input;

import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.UIElementProvidedObject;

public class InputCheckbox extends UIInput {

    protected com.pacgame.provider.component.ui.input.InputCheckbox providedObject;

    public InputCheckbox(UIProvider provider) {
        super(provider);
        providedObject = provider.createInputCheckbox();
    }

    @Override
    protected UIElementProvidedObject getProvidedObject() {
        return null;
    }
}
