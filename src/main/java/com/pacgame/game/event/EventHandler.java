package com.pacgame.game.event;

public interface EventHandler<T> {

    void handle(T e);
}
