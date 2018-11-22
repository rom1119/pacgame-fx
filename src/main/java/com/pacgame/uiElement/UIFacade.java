package com.pacgame.uiElement;

import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.btn.Button;
import com.pacgame.uiElement.btn.ButtonSuccess;
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

    public Button createButtonSuccess(String text)
    {
        return new ButtonSuccess(provider, text);
    }
}
