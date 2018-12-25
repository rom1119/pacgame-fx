package com.pacgame.event.type;

import com.pacgame.EventType;
import com.pacgame.provider.EventProvidedObject;

public class ActionEvent extends Event {

    protected EventProvidedObject providedObject;

    protected static EventType<ActionEvent> ANY_ACTION ;


    public ActionEvent(EventTarget target, Object source) {
        super(target, source, ANY_ACTION);
    }

    public ActionEvent() {
        this(null, null);
    }

    @Override
    protected com.pacgame.provider.event.type.ActionEvent getProvidedObject() {
        return (com.pacgame.provider.event.type.ActionEvent) providedObject;
    }

    @Override
    public void setProvidedObject(EventProvidedObject eventProvidedObject) {
        this.providedObject = eventProvidedObject;
    }
}
