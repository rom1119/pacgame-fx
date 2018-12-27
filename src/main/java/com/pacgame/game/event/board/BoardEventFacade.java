package com.pacgame.game.event.board;

import com.pacgame.game.event.EventHandler;
import com.pacgame.game.event.EventType;

public interface BoardEventFacade {

    EventType<MazeTouchPacman> mazeTouchPacman();
    EventType<PacmanTouchPoint> pacmanTouchPoint();

    <T extends GameBoardEvent> void addEventHandler(T event, EventHandler<? super T> eventHandler);
    <T extends GameBoardEvent> void removeEventHandler(T eventHandler);
}
