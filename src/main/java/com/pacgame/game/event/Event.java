package com.pacgame.game.event;

public abstract class Event {

    public static final EventType<Event> ANY_EVENT = new EventType<>("ANY_EVENT", EventType.ROOT_EVENT);

    private Source source;

    private Target target;

    protected EventType<? extends Event> eventType;

    public Event(Source source, Target target, EventType<? extends Event> eventType) {
        this.source = source;
        this.target = target;
        this.eventType = eventType;
    }

    public Event(Source source, Target target) {
        this(source, target, ANY_EVENT);
    }

    public Source getSource() {
        return source;
    }

    public Target getTarget() {
        return target;
    }

    public EventType<? extends Event> getEventType() {
        return eventType;
    }
}
