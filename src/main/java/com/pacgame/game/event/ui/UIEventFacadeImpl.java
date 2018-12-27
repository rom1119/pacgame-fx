package com.pacgame.game.event.ui;

import com.pacgame.game.EventDispatcher;
import com.pacgame.game.EventDispatcherImpl;
import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.EventType;

public class UIEventFacadeImpl implements UIEventFacade {

    private EventDispatcher<UIEvent> eventDispatcher;

    public UIEventFacadeImpl() {
        eventDispatcher = new EventDispatcherImpl<>();
    }

    @Override
    public EventType<SelectMenuItem> selectMenuItem() {
        return null;
    }

    @Override
    public <T extends UIEvent> void addEventHandler(T event, EventHandler<? super T> eventHandler) {

    }

    @Override
    public <T extends UIEvent> void removeEventHandler(T eventHandler) {

    }
}
