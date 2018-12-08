package com.pacgame.game;

public interface IMenuItem {

    void setOnSelect(IHandler handler);
    void setText(String text);
}
