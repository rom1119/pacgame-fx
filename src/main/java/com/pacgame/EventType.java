package com.pacgame;

import com.pacgame.event.IEventHandler;
import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.EventProvider;
import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.event.type.Event;
import com.pacgame.provider.event.IEventHandlerProvider;

import java.util.HashMap;
import java.util.Map;

public class EventType<T extends Event> {

    public static EventType ROOT;

    private EventTypeProvidedObject<? extends EventProvidedObject> providedObject;
    private EventProvider eventProvider;



    private final String name;
    private final EventType superType;

    private Class<? extends Event> eventClass;
    private Map<IEventHandler<? super T>, IEventHandlerProvider> eventHandlers;

    public EventType(EventType superType, String name, Class<T> eventClass, EventTypeProvidedObject<? extends EventProvidedObject> providedObject) {
        this.name = name;
        this.superType = superType;
        this.providedObject = providedObject;

        this.eventClass = eventClass;
        this.eventHandlers = new HashMap<>();
        initializeRootEventType();
//        this.proxy = createProxy(name);
    }

    private void initializeRootEventType() {
        if (ROOT == null) {
//            ROOT = new EventType( null, "ROOT", EventType.class, eventProvider);
        }
    }

    public EventTypeProvidedObject<? extends EventProvidedObject> getProvidedObject() {
        return providedObject;
    }

    public <M extends EventProvidedObject> IEventHandlerProvider<? super M> addEventHandler(IEventHandler<? super T> eventHandler, T event )
    {

        if (eventHandler == null) {
            throw new NullPointerException("Event handler can not be empty for EventType " + getName());
        }

        if (event == null) {
            throw new NullPointerException("Event " + event.toString() + " can not be empty ");
        }

        if (hasEventHandler(eventHandler)) {
            throw new IllegalArgumentException("Can not add second same eventHandler to EventType " + getName() + " .");
        }
        IEventHandlerProvider eventHandlerProvider = e -> {
            event.setProvidedObject(e);
            event.initTarget(e.getTarget().hashCode());

//            event.setTarget();
            eventHandler.handle(event);
        };

        IEventHandlerProvider handlerProvider = eventHandlers.put(eventHandler, eventHandlerProvider);

        return eventHandlerProvider;
    }

    private boolean hasEventHandler(IEventHandler eventHandler)
    {
        for (Map.Entry<IEventHandler<? super T>, IEventHandlerProvider> el: eventHandlers.entrySet()) {
            if (el.getKey() == eventHandler) {
                return true;
            }
        }

        return false;
    }

    public <M extends EventProvidedObject> IEventHandlerProvider<? super M> removeEventHandler(IEventHandler<? super T> eventHandler)
    {
        if (eventHandler == null) {
            throw new NullPointerException("Event handler can not be empty for EventType " + getName());
        }

        if (!hasEventHandler(eventHandler)) {
            throw new IllegalArgumentException("Can not add remove eventHandler to EventType " + getName() + " . Because not exist.");
        }

        return eventHandlers.remove(eventHandler);
    }
    public T getEvent() {

        T event = null;
        try {
            event = (T) eventClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return event;
    }

    public String getName() {
        return name;
    }
}
