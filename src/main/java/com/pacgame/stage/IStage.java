package com.pacgame.stage;

public interface IStage {
    void setResizable(boolean b);

    void setTitle(String s);

    void show();

    void setScene(IScene scene);
}
