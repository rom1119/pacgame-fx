package com.pacgame.game;

import com.pacgame.game.board.BoardMap;
import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.EventType;

import java.util.*;

public class EventDispatcherImpl<T extends Event> implements EventDispatcher<T> {

    private Map<EventType<T>, List<EventHandler<T>>> eventHandlers;

    public EventDispatcherImpl() {
        eventHandlers = new HashMap<>();
    }

    @Override
    public <S extends T> S dispatchEvent(S event) {

        eventHandlers.forEach((key, val) -> {
            if (event.getEventType().equals(key)) {
                val.forEach(eventHandler -> {
                    eventHandler.handle(event);

                });
            }
        });

        return event;
    }

    @Override
    public <S extends T> void addHandler(EventType<S> eventType, EventHandler<? super S> eventHandler)
    {
        if (eventHandlers.containsKey(eventType)) {
            List<EventHandler<T>> eventHandlerList = this.eventHandlers.get(eventType);
            ArrayList<EventHandler<T>> newEventHandlers = new ArrayList<>(eventHandlerList);
            newEventHandlers.add((EventHandler<T>) eventHandler);

            this.eventHandlers.replace((EventType<T>) eventType, newEventHandlers);
        } else {
            eventHandlers.put((EventType<T>) eventType, Arrays.asList((EventHandler<T>) eventHandler));

        }
    }
}
