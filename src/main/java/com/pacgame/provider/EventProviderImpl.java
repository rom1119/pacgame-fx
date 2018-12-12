package com.pacgame.provider;

import com.pacgame.provider.event.type.KeyEventFacade;
import com.pacgame.provider.event.type.KeyEventFacadeImpl;
import com.pacgame.provider.event.type.MouseEventFacade;
import com.pacgame.provider.event.type.MouseEventFacadeImpl;

public class EventProviderImpl implements EventProvider {
    @Override
    public KeyEventFacade keyEventFacade() {
        return new KeyEventFacadeImpl();
    }

    @Override
    public MouseEventFacade mouseEventFacade() {
        return new MouseEventFacadeImpl();
    }
}
