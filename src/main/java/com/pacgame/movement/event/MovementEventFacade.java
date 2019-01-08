package com.pacgame.movement.event;

public interface MovementEventFacade<T extends MoveEvent> {
    <S extends T> void addEventHandler(S event, MoveEventHandler<? super S> eventHandler);
    <S extends T> void removeEventHandler(S event, MoveEventHandler<? super S> eventHandler);

    <S extends T> void emitEvent(S event);
}
