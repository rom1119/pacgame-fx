package com.pacgame.game;

public interface ILayer extends IView {

    void addElement(IView view);
    void removeElement(IView view);

    int getWidth();
    int getHeight();

    void setWidth(int width);
    void setHeight(int height);
}
