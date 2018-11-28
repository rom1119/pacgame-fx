package com.pacgame.game;

public interface IMenuFactory {

    IMenu createMenu(int width, int height);
    IMenuItem createMenuItem(String text);
}
