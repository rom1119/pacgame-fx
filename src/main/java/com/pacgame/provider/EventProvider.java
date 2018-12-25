package com.pacgame.provider;

import com.pacgame.provider.event.type.ActionEventFacade;
import com.pacgame.provider.event.type.KeyEventFacade;
import com.pacgame.provider.event.type.MouseEventFacade;

public interface EventProvider {

    KeyEventFacade keyEventFacade();

    MouseEventFacade mouseEventFacade();

    ActionEventFacade actionEventFacade();
}
