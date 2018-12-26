package com.pacgame.game.adapter.event;

import com.pacgame.event.type.Event;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public abstract class EventAdapter {

    protected Source source;
    protected Target target;
    protected Event providedObject;

    public EventAdapter(Source source, Target target) {
        this.source = source;
        this.target = target;
    }

    public Event getProvidedObject() {
        return providedObject;
    }

    public void setProvidedObject(Event providedObject) {
        this.providedObject = providedObject;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Source getSource() {
        return source;
    }

    public Target getTarget() {
        return target;
    }
}
