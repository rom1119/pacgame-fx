package com.pacgame.uiElement.text;

import com.pacgame.provider.component.ui.text.LabelBuilder;
import com.pacgame.uiElement.UIElement;

public abstract class Text extends UIElement {

    protected com.pacgame.provider.component.ui.text.Label providedObject;

    public Text(int width, int height, com.pacgame.provider.component.ui.text.Label providedObject) {
        super(width, height);
        this.providedObject = providedObject;
    }

    public String getText()
    {
        return providedObject.getText();
    }
}
