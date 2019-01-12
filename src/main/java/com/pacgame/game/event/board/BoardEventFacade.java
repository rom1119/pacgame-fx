package com.pacgame.game.event.board;

import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.game.event.*;

public interface BoardEventFacade {

    EventType<MazeTouchPacman> onMazeTouchPacman();

    EventType<PacmanTouchPoint> onPacmanTouchPoint();

    PacmanTouchPoint createPacmanTouchPoint(Source source, Target target, IPoint point);
    BoardElementMove createPacmanMove(Source source, Target target, int x, int y);

    EventType<BoardElementMove> onPacmanMove();
    EventType<BoardElementMove> onMazeMove();

    <T extends GameBoardEvent> void addEventHandler(EventType<T> event, EventHandler<? super T> eventHandler);
    <T extends GameBoardEvent> void removeEventHandler(EventType<T> event, EventHandler<? super T> eventHandler);

    <T extends GameBoardEvent> void emitEvent(T event);

}
