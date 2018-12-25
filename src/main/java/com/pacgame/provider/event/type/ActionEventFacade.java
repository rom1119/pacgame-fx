package com.pacgame.provider.event.type;

import com.pacgame.provider.EventTargetProvidedObject;
import com.pacgame.provider.EventTypeProvidedObject;

public interface ActionEventFacade {

    ActionEvent createEvent(EventTargetProvidedObject target, Object source);


    EventTypeProvidedObject<ActionEvent> any();
}
