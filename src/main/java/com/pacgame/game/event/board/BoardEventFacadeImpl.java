package com.pacgame.game.event.board;

import com.pacgame.game.EventDispatcher;
import com.pacgame.game.EventDispatcherImpl;
import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.EventType;

import java.util.HashMap;
import java.util.Map;

public class BoardEventFacadeImpl implements BoardEventFacade {

    private EventDispatcher<GameBoardEvent> eventDispatcher;

    public BoardEventFacadeImpl() {
        eventDispatcher = new EventDispatcherImpl<>();
    }

    @Override
    public EventType<MazeTouchPacman> mazeTouchPacman() {
        return null;
    }

    @Override
    public EventType<PacmanTouchPoint> pacmanTouchPoint() {
        return null;
    }

    @Override
    public <T extends GameBoardEvent> void addEventHandler(T event, EventHandler<? super T> eventHandler) {

    }

    @Override
    public <T extends GameBoardEvent> void removeEventHandler(T eventHandler) {

    }
}
