package com.pacgame.game.event;

import com.pacgame.game.PlatformTools;

public interface AppEventFacade {

    ExitGame createExitGameEvent(Source source, Target target, EventType<ExitGame> eventType);

    EventType<ExitGame> onExitGame();

    <T extends AppEvent> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler);
    <T extends AppEvent> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler);

    <T extends AppEvent> void emitEvent(T event);
}
