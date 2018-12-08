package com.pacgame.provider;

import com.pacgame.provider.component.ui.button.ButtonProvidedObject;
import com.pacgame.provider.component.ui.input.InputCheckbox;
import com.pacgame.provider.component.ui.input.InputPassword;
import com.pacgame.provider.component.ui.input.InputText;
import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.uiElement.text.Text;

public interface UIProvider {

    Label createTextElement(String text);
    ButtonProvidedObject createButtonSuccess(String text);
    ButtonProvidedObject createButtonDanger(String text);
    InputText createInputText();
    InputPassword createInputPassword();
    InputCheckbox createInputCheckbox();

}
