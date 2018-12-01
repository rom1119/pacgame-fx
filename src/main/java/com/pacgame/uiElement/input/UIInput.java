package com.pacgame.uiElement.input;

import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.UIElementProvidedObject;
import com.pacgame.uiElement.UIElement;

public abstract class UIInput extends UIElement {

    public UIInput(UIProvider provider, int width, int height) {
        super(provider, width, height);
    }

    public UIInput(UIProvider provider) {
        super(provider);
    }

    @Override
    protected abstract UIElementProvidedObject getProvidedObject();
}
