package com.pacgame.movement.event;

public interface MoveEventDispatcher<T extends MoveEvent> {

    <S extends T> S dispatchEvent(S event);

    <S extends T> void addHandler(S eventType, MoveEventHandler<? super S> eventHandler);
}
