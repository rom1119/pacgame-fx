package com.pacgame.movement.event;

public interface MoveEventHandler<T extends MoveEvent> {

    void handle(T event);
}
