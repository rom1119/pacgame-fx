package com.pacgame.game;

public interface ISceneFactory {

    IScene createScene(ILayer layer, int width, int height);
}
