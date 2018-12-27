package com.pacgame.game.event;

import com.pacgame.game.PlatformTools;

public interface AppEventFacade {

    ExitGame exitGame();

    <T extends AppEvent> void addEventHandler(T event, EventHandler<? super T> eventHandler);
    <T extends AppEvent> void removeEventHandler(T eventHandler);

    <T extends AppEvent> void emitEvent(T event);
}
