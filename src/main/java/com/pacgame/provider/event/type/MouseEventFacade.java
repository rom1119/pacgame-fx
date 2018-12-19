package com.pacgame.provider.event.type;

import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.provider.EventTargetProvidedObject;

public interface MouseEventFacade {

    MouseEvent createEvent(EventTargetProvidedObject target, Object source, EventTypeProvidedObject eventType);

    EventTypeProvidedObject<MouseEvent> any();

    EventTypeProvidedObject<MouseEvent> move();

    EventTypeProvidedObject<MouseEvent> click();

    EventTypeProvidedObject<MouseEvent> enter();

    EventTypeProvidedObject<MouseEvent> enterTarget();

    EventTypeProvidedObject<MouseEvent> exitTarget();

}
