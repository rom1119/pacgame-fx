package com.pacgame.game.event.board;

import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class PacmanTouchPoint extends GameBoardEvent {

    public PacmanTouchPoint(Source source, Target target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public PacmanTouchPoint(Source source, Target target) {
        super(source, target);
    }

    public IPacman getPacman()
    {
        return null;
    }

    public IPoint getPoint()
    {
        return null;
    }

}
