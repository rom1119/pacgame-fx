package com.pacgame.event;

public interface IEventHandler<T> {

    void handle(T event);
}
