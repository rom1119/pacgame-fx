package com.pacgame.game.event.ui;

import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.EventType;

public interface UIEventFacade {

    EventType<SelectMenuItem> selectMenuItem();

    <T extends UIEvent> void addEventHandler(T event, EventHandler<? super T> eventHandler);
    <T extends UIEvent> void removeEventHandler(T eventHandler);
}
