package com.pacgame.uiElement;

import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.text.Label;
import com.pacgame.uiElement.text.Text;

public class UIFacade {

    private UIProvider provider;

    public UIFacade(UIProvider provider) {
        this.provider = provider;
    }

    public Text createTextElement(String text)
    {
        return new Label(provider, text);
    }
}
