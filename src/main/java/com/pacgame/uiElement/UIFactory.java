package com.pacgame.uiElement;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.btn.Button;
import com.pacgame.uiElement.btn.ButtonSuccess;
import com.pacgame.uiElement.input.InputText;
import com.pacgame.uiElement.text.Label;
import com.pacgame.uiElement.text.Text;

public class UIFactory {

    private UIProvider provider;

    public UIFactory(UIProvider provider) {
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

    public InputText createTextArea()
    {
        return new InputText(provider);
    }

}
