package com.pacgame.movement.event;

public interface MoveEventDispatcher<T extends MoveEvent> {

    <S extends T> S dispatchEvent(S event);

    public <S extends T> void addHandler(MoveEvent eventType, MoveEventHandler<? super S> eventHandler);
}
