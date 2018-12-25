package com.pacgame.event.type;

import com.pacgame.EventType;
import com.pacgame.provider.EventTargetProvidedObject;

public class ActionEventFacadeImpl implements ActionEventFacade {

    private com.pacgame.provider.event.type.ActionEventFacade actionEventFacade;

    public ActionEventFacadeImpl(com.pacgame.provider.event.type.ActionEventFacade actionEventFacade) {
        this.actionEventFacade = actionEventFacade;
        ActionEvent.ANY_ACTION = new EventType<ActionEvent>(null , "ANY_ACTION", ActionEvent.class , actionEventFacade.any());

    }

    @Override
    public ActionEvent newEvent(EventTarget target, EventSource source) {
        ActionEvent actionEvent = new ActionEvent(target, source);
        actionEvent.setProvidedObject(actionEventFacade.createEvent((EventTargetProvidedObject) target.getProvidedObject(), source.getProvidedObject()));
        return actionEvent;
    }

    @Override
    public EventType<ActionEvent> any() {
        return ActionEvent.ANY_ACTION;
    }
}
