package com.pacgame.provider.event.type;

import com.pacgame.provider.EventTargetProvidedObject;
import com.pacgame.provider.EventTypeProvidedObject;

public class ActionEventFacadeImpl implements ActionEventFacade {
    @Override
    public ActionEvent createEvent(EventTargetProvidedObject target, Object source) {
        return new ActionEvent(target, source);
    }

    @Override
    public EventTypeProvidedObject<ActionEvent> any() {
        return ActionEvent.ANY_ACTION;
    }
}
