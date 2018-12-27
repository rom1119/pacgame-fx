package com.pacgame.game.event;

import com.pacgame.game.EventDispatcher;
import com.pacgame.game.EventDispatcherImpl;
import com.pacgame.game.PlatformTools;

public class AppEventFacadeImpl implements AppEventFacade {
    private EventDispatcher<AppEvent> eventDispatcher;
    private static final ExitGame exitGame = new ExitGameImpl();
    private PlatformTools platformTools;

    public AppEventFacadeImpl() {
        eventDispatcher = new EventDispatcherImpl<>();
    }

    @Override
    public <T extends AppEvent> void addEventHandler(T event, EventHandler<? super T> eventHandler) {
        eventDispatcher.addHandler(event, eventHandler);
    }

    @Override
    public <T extends AppEvent> void removeEventHandler(T eventHandler) {

    }

    @Override
    public <T extends AppEvent> void emitEvent(T event) {
        eventDispatcher.dispatchEvent(event);
    }

    @Override
    public ExitGame exitGame() {
        return exitGame;
    }


}
