package com.pacgame.uiElement.text;

import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.provider.component.ui.text.LabelBuilder;
import com.pacgame.uiElement.UIElement;

public abstract class Text extends UIElement {

    protected com.pacgame.provider.component.ui.text.Label providedObject;

    public Text(UIProvider provider, String text) {
        super(provider);
        this.providedObject = provider.createTextElement(text);
    }

    public String getText()
    {
        return providedObject.getText();
    }
}
