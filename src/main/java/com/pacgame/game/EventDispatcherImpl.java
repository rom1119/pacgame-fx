package com.pacgame.game;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.board.GameBoardEvent;
import com.pacgame.game.event.board.GameBoardEventHandler;

import java.util.*;

public class EventDispatcherImpl<T extends Event> implements EventDispatcher<T> {

    private Map<T, List<EventHandler>> eventHandlers;

    public EventDispatcherImpl() {
        eventHandlers = new HashMap<>();
    }

    @Override
    public <S extends T> S dispatchEvent(S event) {

        eventHandlers.get(event).forEach(eventHandler -> {
            eventHandler.handle(event);
        });

        return event;
    }

    @Override
    public <S extends T> void addHandler(S event, EventHandler<? super S> eventHandler)
    {
        if (eventHandlers.containsKey(event)) {
            eventHandlers.get(event).add(eventHandler);
        } else {
            eventHandlers.put(event, Arrays.asList(eventHandler));

        }
    }
}
