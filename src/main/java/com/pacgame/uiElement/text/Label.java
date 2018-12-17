package com.pacgame.uiElement.text;

import com.pacgame.provider.EventProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.UIElement;

public class Label extends Text {


    public Label(UIProvider provider, EventProvider eventProvider, String text) {
        super(provider, text);
        providedObject = provider.createTextElement(text);
    }
}
