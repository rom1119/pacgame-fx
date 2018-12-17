package com.pacgame.game;

public interface IView {
    void hide();
    void show();
    boolean isVisible();
    void setBackground(IColor color);

    void setX(int x);
    void setY(int y);
}
