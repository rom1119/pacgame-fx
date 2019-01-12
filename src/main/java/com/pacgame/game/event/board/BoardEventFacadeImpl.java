package com.pacgame.game.event.board;

import com.pacgame.game.EventDispatcher;
import com.pacgame.game.EventDispatcherImpl;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

import java.util.HashMap;
import java.util.Map;

public class BoardEventFacadeImpl implements BoardEventFacade {

    private EventDispatcher<GameBoardEvent> eventDispatcher;

    public BoardEventFacadeImpl() {
        eventDispatcher = new EventDispatcherImpl<>();
    }

    @Override
    public EventType<MazeTouchPacman> onMazeTouchPacman() {
        return MazeTouchPacman.MAZE_TOUCH_PACMAN_ANY_EVENT;
    }

    @Override
    public EventType<PacmanTouchPoint> onPacmanTouchPoint() {
        return PacmanTouchPoint.PACMAN_TOUCH_POINT_ANY_EVENT;
    }

    @Override
    public PacmanTouchPoint createPacmanTouchPoint(Source source, Target target, IPoint point) {
        return new PacmanTouchPoint(source, target, PacmanTouchPoint.PACMAN_TOUCH_POINT_ANY_EVENT, point);
    }

    @Override
    public BoardElementMove createPacmanMove(Source source, Target target, int x, int y) {
        return new BoardElementMove(source, target, BoardElementMove.PACMAN_MOVE_EVENT, x, y);
    }

    @Override
    public EventType<BoardElementMove> onPacmanMove() {
        return BoardElementMove.PACMAN_MOVE_EVENT;
    }

    @Override
    public EventType<BoardElementMove> onMazeMove() {
        return BoardElementMove.MAZE_MOVE_EVENT;
    }

    @Override
    public <T extends GameBoardEvent> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        eventDispatcher.addHandler(eventType, eventHandler);
    }

    @Override
    public <T extends GameBoardEvent> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {

    }

    @Override
    public <T extends GameBoardEvent> void emitEvent(T event) {
        eventDispatcher.dispatchEvent(event);
    }

}
