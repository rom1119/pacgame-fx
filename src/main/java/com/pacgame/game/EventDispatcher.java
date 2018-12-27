package com.pacgame.game;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventHandler;

public interface EventDispatcher<T extends Event> {

    <S extends T> S dispatchEvent(S event);

    <S extends T> void addHandler(S event, EventHandler<? super S> eventHandler);
}
