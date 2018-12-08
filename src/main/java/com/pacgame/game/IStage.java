package com.pacgame.game;

public interface IStage {

    void setResizable(boolean b);

    void setTitle(String s);

    void show();

    void setScene(IScene scene);
}
