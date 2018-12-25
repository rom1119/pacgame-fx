package com.pacgame.event.type;

import com.pacgame.EventType;

public interface ActionEventFacade {

    ActionEvent newEvent(EventTarget target, EventSource source);

    EventType<ActionEvent> any();

}
