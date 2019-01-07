package com.pacgame.movement.event;

public interface MovementEventFacade {
    <T extends MoveEvent> void addEventHandler(MoveEvent event, MoveEventHandler<? super T> eventHandler);
    <T extends MoveEvent> void removeEventHandler(MoveEvent event, MoveEventHandler<? super T> eventHandler);

    <T extends MoveEvent> void emitEvent(T event);
}
