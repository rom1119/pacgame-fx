package com.pacgame.game.adapter;

import com.pacgame.game.IButton;
import com.pacgame.game.IColor;
import com.pacgame.uiElement.btn.Button;

public class ButtonAdapter implements IButton {

    private Button button;

    public ButtonAdapter(Button button) {
        this.button = button;
    }

    @Override
    public void hide() {
        button.hide();
    }

    @Override
    public void show() {
        button.show();
    }

    @Override
    public void setBackground(IColor color) {
        button.setBackground(((ColorAdapter)color).getValue());
    }
}
