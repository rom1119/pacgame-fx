package com.pacgame.game;

public interface IMenu extends IView {

    void addMenuItem(IMenuItem item);
    void removeMenuItem(IMenuItem item);

    void setWidth(int width);
    void setHeight(int height);
}
