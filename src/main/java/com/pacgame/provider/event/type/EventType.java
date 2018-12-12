package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.ProvidedObject;

public class EventType<T extends EventProvidedObject> extends ProvidedObject {

    public static final EventType<EventProvidedObject> ROOT = new EventType<EventProvidedObject>( null, "ROOT");

    private EventTypeProxy proxy;

    private final String name;
    private final EventType<? super T> superType;

    private Class<T> clazz;

    public EventType( EventType<? super T> superType, String name) {
        this.name = name;
        this.superType = superType;

        this.proxy = createProxy(name);
    }

    private EventTypeProxy createProxy(String name) {
        return new EventTypeProxy(name, clazz);

    }

    @Override
    public EventTypeProxy getProxy() {
        return proxy;
    }
}
