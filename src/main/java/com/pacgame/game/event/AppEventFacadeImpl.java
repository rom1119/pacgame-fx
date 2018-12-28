package com.pacgame.game.event;

import com.pacgame.game.EventDispatcher;
import com.pacgame.game.EventDispatcherImpl;
import com.pacgame.game.PlatformTools;

public class AppEventFacadeImpl implements AppEventFacade {
    private EventDispatcher<AppEvent> eventDispatcher;
    private static final EventType<ExitGame> exitGame = ExitGame.APP_EXIT_EVENT;
    private PlatformTools platformTools;

    public AppEventFacadeImpl() {
        eventDispatcher = new EventDispatcherImpl<>();
    }

    @Override
    public <T extends AppEvent> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        eventDispatcher.addHandler(eventType, eventHandler);
    }

    @Override
    public <T extends AppEvent> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {

    }

    @Override
    public <T extends AppEvent> void emitEvent(T event) {
        eventDispatcher.dispatchEvent(event);
    }

    @Override
    public ExitGame createExitGameEvent(Source source, Target target, EventType<ExitGame> eventType) {
        return new ExitGame(source, target, eventType);
    }

    @Override
    public EventType<ExitGame> onExitGame() {
        return ExitGame.APP_EXIT_EVENT;
    }


}
