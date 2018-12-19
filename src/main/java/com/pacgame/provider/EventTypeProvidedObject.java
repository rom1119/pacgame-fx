package com.pacgame.provider;

import com.pacgame.provider.event.type.EventTypeProxy;

public class EventTypeProvidedObject<T extends EventProvidedObject> extends ProvidedObject {

    public static final EventTypeProvidedObject ROOT = new EventTypeProvidedObject( null, "ROOT", EventProvidedObject.class);

    private EventTypeProxy proxy;

    private final String name;
    private final EventTypeProvidedObject superType;

    private Class<? extends EventProvidedObject> eventClass;

    public EventTypeProvidedObject(EventTypeProvidedObject superType, String name, Class<T> eventClass) {
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
