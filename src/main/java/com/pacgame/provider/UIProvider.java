package com.pacgame.provider;

import com.pacgame.provider.component.ui.button.ButtonProvidedObject;
import com.pacgame.provider.component.ui.text.Label;

public interface UIProvider {

    Label createTextElement(String text);
    ButtonProvidedObject createButtonSuccess(String text);
}
