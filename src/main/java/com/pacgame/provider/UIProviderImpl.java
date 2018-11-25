package com.pacgame.provider;

import com.pacgame.provider.component.ui.button.ButtonDanger;
import com.pacgame.provider.component.ui.button.ButtonProvidedObject;
import com.pacgame.provider.component.ui.button.ButtonSuccess;
import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.uiElement.text.Text;

public class UIProviderImpl implements UIProvider {
    @Override
    public Label createTextElement(String text) {
        return new Label(text);
    }

    @Override
    public ButtonProvidedObject createButtonSuccess(String text) {
        return new ButtonSuccess(text);
    }

    @Override
    public ButtonProvidedObject createButtonDanger(String text) {
        return new ButtonDanger(text);
    }


}
