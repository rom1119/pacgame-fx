package com.pacgame.provider.event.handler;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.event.IEventHandlerProvider;
import com.pacgame.provider.EventTypeProvidedObject;

import java.util.*;

public class EventHandlerManager {

    private final Map<EventTypeProvidedObject<? extends EventProvidedObject>, EventHandlerProperty> eventHandlers;

    public EventHandlerManager() {
        eventHandlers = new HashMap<>();
    }

//    public <T extends EventProxy> void addEventhandler(EventTypeProxy<T> eventTypeProxy, IEventHandlerProxy<? super T> eventHandler) {
//
//    }

    public static class EventHandlerProperty<T extends EventProvidedObject> {
        private IEventHandlerProvider<T> value;
        private String name;


        public void handle(T event) {
//            value.getProxy();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EventHandlerProperty<?> that = (EventHandlerProperty<?>) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name);
        }
    }
}
