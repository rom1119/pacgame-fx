package com.pacgame.provider;

import com.pacgame.provider.event.type.*;

public class EventProviderImpl implements EventProvider {
    @Override
    public KeyEventFacade keyEventFacade() {
        return new KeyEventFacadeImpl();
    }

    @Override
    public MouseEventFacade mouseEventFacade() {
        return new MouseEventFacadeImpl();
    }

    @Override
    public ActionEventFacade actionEventFacade() {
        return new ActionEventFacadeImpl();
    }
}
