package com.pacgame.game.adapter;

import com.pacgame.View;
import com.pacgame.game.IColor;
import com.pacgame.game.IInputText;
import com.pacgame.uiElement.input.InputText;

public class InputTextAdapter extends ViewAdapter implements IInputText {

    private InputText inputText;

    public InputTextAdapter(InputText inputText) {
        this.inputText = inputText;
    }

    @Override
    public void hide() {
        inputText.hide();
    }

    @Override
    public void show() {
        inputText.show();
    }

    @Override
    public void setBackground(IColor color) {
        inputText.setBackground(((ColorAdapter)color).getValue());
    }

    @Override
    public View getProvidedObject() {
        return inputText;
    }

    public void setWidth(int width){
        inputText.setWidth(width);
    }

    public void setHeight(int height){
        inputText.setHeight(height);
    }
}
