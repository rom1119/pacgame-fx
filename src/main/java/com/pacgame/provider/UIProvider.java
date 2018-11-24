package com.pacgame.provider;

import com.pacgame.provider.component.ui.button.ButtonProvidedObject;
import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.uiElement.text.Text;

public interface UIProvider {

    Label createTextElement(String text);
    ButtonProvidedObject createButtonSuccess(String text);

    LayerProvidedObject createMenu(int width, int height);

    Text createMenuElement();
}
