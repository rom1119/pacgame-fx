package com.pacgame.game;

public interface ILayer extends IView {

    void addElement(IView view);
    void removeElement(IView view);
}
