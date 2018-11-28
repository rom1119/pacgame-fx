package com.pacgame.game;

public interface IUIComponentFactory {

    IUIComponent createButton(IColor color, String text);
    IUIComponent createInputText(int width, int height);
    IUIComponent createLabelText(String text);

}
