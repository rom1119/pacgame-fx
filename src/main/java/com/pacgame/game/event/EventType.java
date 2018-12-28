package com.pacgame.game.event;

public class EventType<T extends Event> {

    public static final EventType<Event> ROOT_EVENT = new EventType<>("ROOT_EVENT", null);

    private final EventType<? super T> superType;

    private String name;

    public EventType() {
        this(ROOT_EVENT, null);
    }

    public EventType(String name) {
        this(ROOT_EVENT, name);
    }

    public EventType(EventType<? super T> superType) {
        this(superType, null);
    }

    public EventType(EventType<? super T> superType, String name) {
        this.superType = superType;
        this.name = name;
    }

    EventType(String name, EventType<? super T> superType) {
        this.superType = superType;
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
