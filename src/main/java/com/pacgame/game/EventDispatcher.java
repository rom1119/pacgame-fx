package com.pacgame.game;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.EventType;

public interface EventDispatcher<T extends Event> {

    <S extends T> S dispatchEvent(S event);

    public <S extends T> void addHandler(EventType<S> eventType, EventHandler<? super S> eventHandler);
}
