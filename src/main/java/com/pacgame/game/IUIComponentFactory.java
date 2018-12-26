package com.pacgame.game;

public interface IUIComponentFactory {

    IButton createButton(String text);
    IInputText createInputText(int width, int height);
    ILabel createLabelText(String text);

}
