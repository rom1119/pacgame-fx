package com.pacgame.movement.impl.pointToPoint.event;

import com.pacgame.movement.event.MoveEventDispatcher;
import com.pacgame.movement.event.MoveEventHandler;

import java.util.*;

class EventDispatcher<T extends BaseMoveEventBetweenPoints> implements MoveEventDispatcher<T> {

    private Map<T, List<MoveEventHandler<T>>> eventHandlers;

    public EventDispatcher() {
        eventHandlers = new HashMap<>();
    }

    @Override
    public <S extends T> S dispatchEvent(S event) {
        eventHandlers.forEach((key, val) -> {
            if (event.getName().equals(key.getName())) {
                val.forEach(eventHandler -> {
                    eventHandler.handle(event);

                });
            }
        });

        return event;
    }

    @Override
    public <S extends T> void addHandler(S event, MoveEventHandler<? super S> eventHandler)
    {
        if (eventHandlers.containsKey(event)) {
            List<MoveEventHandler<T>> moveEventHandlers = this.eventHandlers.get(event);
            ArrayList<MoveEventHandler<T>> newEventHandlers = new ArrayList<>(moveEventHandlers);
            newEventHandlers.add((MoveEventHandler<T>) eventHandler);

            this.eventHandlers.replace(event, newEventHandlers);
        } else {
            eventHandlers.put( event, Arrays.asList((MoveEventHandler<T>) eventHandler));

        }
    }
}
