package com.pacgame.event;

import com.pacgame.event.type.*;
import com.pacgame.provider.EventProvider;

public class EventFacadeImpl implements EventFacade {

    private final KeyEventFacade keyEventFacade;
    private final MouseEventFacade mouseEventFacade;
    private final ActionEventFacade actionEventFacade;

    public EventFacadeImpl(EventProvider eventProvider) {
        this.keyEventFacade = new KeyEventFacadeImpl(eventProvider.keyEventFacade());
        this.mouseEventFacade = new MouseEventFacadeImpl(eventProvider.mouseEventFacade());
        this.actionEventFacade = new ActionEventFacadeImpl(eventProvider.actionEventFacade());
    }

    @Override
    public KeyEventFacade keyEventFacade() {
        return keyEventFacade;
    }

    @Override
    public MouseEventFacade mouseEventFacade() {
        return mouseEventFacade;
    }

    @Override
    public ActionEventFacade actionEventFacade() {
        return actionEventFacade;
    }
}
