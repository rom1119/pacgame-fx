package com.pacgame.provider;

import com.pacgame.provider.event.type.EventTypeProxy;

public class EventType<T extends EventProvidedObject> extends ProvidedObject {

    public static final EventType ROOT = new EventType( null, "ROOT", EventProvidedObject.class);

    private EventTypeProxy proxy;

    private final String name;
    private final EventType superType;

    private Class<? extends EventProvidedObject> eventClass;

    public EventType(EventType superType, String name, Class<? extends EventProvidedObject> eventClass) {
        this.name = name;
        this.superType = superType;

        this.eventClass = eventClass;
        this.proxy = createProxy(name);
    }

    private EventTypeProxy createProxy(String name) {
        return new EventTypeProxy(name, eventClass);

    }

    @Override
    protected EventTypeProxy getProxy() {
        return proxy;
    }

    protected T getEvent() {

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
