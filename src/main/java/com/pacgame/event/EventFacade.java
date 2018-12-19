package com.pacgame.event;

import com.pacgame.event.type.KeyEventFacade;
import com.pacgame.event.type.MouseEventFacade;

public interface EventFacade {

    KeyEventFacade keyEventFacade();

    MouseEventFacade mouseEventFacade();
}
