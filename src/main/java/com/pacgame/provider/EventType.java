package com.pacgame.provider;

import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.event.type.KeyEventProxy;
import com.pacgame.provider.event.type.MouseEventProxy;
import org.openqa.selenium.InvalidArgumentException;

public class EventType<T extends EventProvidedObject> extends ProvidedObject {

    public static final EventType<EventProvidedObject> ROOT = new EventType<EventProvidedObject>( null, "ROOT");

    private EventTypeProxy<? extends EventProxy> proxy;

    private final String name;
    private final EventType<? super T> superType;

    private Class<T> clazz;

    public EventType( EventType<? super T> superType, String name) {
        this.name = name;
        this.superType = superType;

        this.proxy = createProxy(name);
    }

    private EventTypeProxy createProxy(String name) {
        T type = null;
        try {
            type = clazz.newInstance();
            if (type instanceof com.pacgame.provider.event.type.KeyEvent) {
                return new EventTypeProxy<KeyEventProxy>(name);
            } else if (type instanceof com.pacgame.provider.event.type.MouseEvent) {
                return new EventTypeProxy<MouseEventProxy>(name);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        throw new InvalidArgumentException("Event type is not supported for type " + type.toString());
    }

    @Override
    protected EventTypeProxy getProxy() {
        return proxy;
    }
}
