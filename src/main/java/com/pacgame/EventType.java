package com.pacgame;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.EventProvider;
import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.event.type.Event;

public class EventType<T extends Event> {

    public static EventType ROOT;

    private EventTypeProvidedObject<? extends EventProvidedObject> providedObject;
    private EventProvider eventProvider;

    private final String name;
    private final EventType superType;

    private Class<? extends Event> eventClass;

    public EventType(EventType superType, String name, Class<T> eventClass, EventTypeProvidedObject<? extends EventProvidedObject> providedObject) {
        this.name = name;
        this.superType = superType;
        this.providedObject = providedObject;

        this.eventClass = eventClass;
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

//    private EventTypeProxy createProxy(String name) {
//        return new EventTypeProxy(name, eventClass);
//
//    }
//
//    @Override
//    protected EventTypeProxy getProxy() {
//        return proxy;
//    }
//
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
}
