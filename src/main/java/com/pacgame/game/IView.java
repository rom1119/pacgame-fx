package com.pacgame.game;

import com.pacgame.game.event.Target;

public interface IView extends Target {
    void hide();
    void show();
    boolean isVisible();
    void setBackground(IColor color);

    void setX(int x);
    void setY(int y);

    int getX();

    int getY();
}
