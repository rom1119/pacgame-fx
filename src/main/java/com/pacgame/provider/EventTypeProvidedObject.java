package com.pacgame.provider;

import com.pacgame.provider.event.IEventHandler;
import com.pacgame.provider.event.type.EventTypeProxy;

import java.util.HashMap;
import java.util.Map;

public class EventTypeProvidedObject<T extends EventProvidedObject> extends ProvidedObject {

    public static final EventTypeProvidedObject ROOT = new EventTypeProvidedObject( null, "ROOT", EventProvidedObject.class);

    private EventTypeProxy proxy;

    private final String name;
    private final EventTypeProvidedObject superType;

    private Map<IEventHandler, Integer> eventHandlers;

    private Class<? extends EventProvidedObject> eventClass;

    public EventTypeProvidedObject(EventTypeProvidedObject superType, String name, Class<T> eventClass) {
        this.name = name;
        this.superType = superType;

        this.eventClass = eventClass;
        this.proxy = createProxy(name);
        this.eventHandlers = new HashMap<>();
    }

    private EventTypeProxy createProxy(String name) {
        return new EventTypeProxy(name, eventClass);

    }

    @Override
    protected EventTypeProxy getProxy() {
        return proxy;
    }

    public <T extends EventProvidedObject> int addEventHandler( IEventHandler<? super T> eventHandler, T event)
    {

        if (eventHandler == null) {
            throw new NullPointerException("Event handler can not be empty for EventType " + getProxy().getName());
        }

        if (event == null) {
            throw new NullPointerException("Event " + event.toString() + " can not be empty ");
        }

        if (hasEventHandler(eventHandler)) {
            throw new IllegalArgumentException("Can not add second same eventHandler to EventType " + getProxy().getName() + " .");
        }
//        EventHandler eventHandlerProxy = eventType.getProxy().addEventHandlerProxy(e -> {
////            System.out.println(e.getSource());
////            System.out.println(e.getTarget());
//            event.getProxy().setProxyObject(e);
//            if (e.getTarget() instanceof Text) {
//                event.initTarget(((Text) e.getTarget()).getParent().hashCode());
//
//            } else {
//                event.initTarget(e.getTarget().hashCode());
//
//            }
//            eventHandler.handle(event);
//        });
        int addEventHandlerProxyId = getProxy().addEventHandlerProxy(event.getProxy(), event, eventHandler);

        eventHandlers.put(eventHandler, addEventHandlerProxyId);

        return addEventHandlerProxyId;
    }

    private boolean hasEventHandler(IEventHandler eventHandler)
    {
        for (Map.Entry<IEventHandler, Integer> el: eventHandlers.entrySet()) {
            if (el.getKey() == eventHandler) {
                return true;
            }
        }

        return false;
    }

    public <T extends EventProvidedObject> int removeEventHandler(IEventHandler<? super T> eventHandler)
    {
        if (eventHandler == null) {
            throw new NullPointerException("Event handler can not be empty for EventType " + getProxy().getName());
        }

        if (!hasEventHandler(eventHandler)) {
            throw new IllegalArgumentException("Can not add remove eventHandler to EventType " + getProxy().getName() + " . Because not exist.");
        }

        return eventHandlers.remove(eventHandler);
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
