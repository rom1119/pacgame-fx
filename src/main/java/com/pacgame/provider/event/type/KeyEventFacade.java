package com.pacgame.provider.event.type;

import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.provider.EventTargetProvidedObject;

public interface KeyEventFacade {

    KeyEvent createEvent(EventTargetProvidedObject target, Object source, EventTypeProvidedObject eventType);

    EventTypeProvidedObject<KeyEvent> keyPressed();
    EventTypeProvidedObject<KeyEvent> any();

}
