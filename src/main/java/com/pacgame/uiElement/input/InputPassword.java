package com.pacgame.uiElement.input;

import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.UIElementProvidedObject;

public class InputPassword extends UIInput {

    protected com.pacgame.provider.component.ui.input.InputPassword providedObject;

    public InputPassword(UIProvider provider) {
        super(provider);
        providedObject = provider.createInputPassword();
    }

    @Override
    protected UIElementProvidedObject getProvidedObject() {
        return providedObject;
    }
}
