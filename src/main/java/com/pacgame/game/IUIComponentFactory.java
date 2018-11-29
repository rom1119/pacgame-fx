package com.pacgame.game;

public interface IUIComponentFactory {

    IUIComponent createButtonSuccess( String text);
    IUIComponent createInputText(int width, int height);
    IUIComponent createLabelText(String text);

}
