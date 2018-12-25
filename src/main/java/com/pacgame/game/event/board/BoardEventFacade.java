package com.pacgame.game.event.board;

import com.pacgame.game.event.EventType;

public interface BoardEventFacade {

    EventType<MazeTouchPacman> mazeTouchPacman();
    EventType<PacmanTouchPoint> pacmanTouchPoint();
}
