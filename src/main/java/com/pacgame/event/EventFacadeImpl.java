package com.pacgame.event;

import com.pacgame.event.type.KeyEventFacade;
import com.pacgame.event.type.KeyEventFacadeImpl;
import com.pacgame.event.type.MouseEventFacade;
import com.pacgame.event.type.MouseEventFacadeImpl;
import com.pacgame.provider.EventProvider;

public class EventFacadeImpl implements EventFacade {

    private final KeyEventFacade keyEventFacade;
    private final MouseEventFacade mouseEventFacade;

    public EventFacadeImpl(EventProvider eventProvider) {
        this.keyEventFacade = new KeyEventFacadeImpl(eventProvider.keyEventFacade());
        this.mouseEventFacade = new MouseEventFacadeImpl(eventProvider.mouseEventFacade());
    }

    @Override
    public KeyEventFacade keyEventFacade() {
        return keyEventFacade;
    }

    @Override
    public MouseEventFacade mouseEventFacade() {
        return mouseEventFacade;
    }
}
