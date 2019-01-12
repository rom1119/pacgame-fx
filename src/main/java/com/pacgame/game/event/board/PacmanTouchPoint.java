package com.pacgame.game.event.board;

import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.board.model.point.IPoint;
import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class PacmanTouchPoint extends GameBoardEvent {

    public static final EventType<PacmanTouchPoint> PACMAN_TOUCH_POINT_ANY_EVENT = new EventType<>(GameBoardEvent.GAME_BOARD_ANY_EVENT, "PACMAN_TOUCH_POINT_ANY_EVENT");

    private IPoint point;

    public PacmanTouchPoint(Source source, Target target, EventType<? extends Event> eventType, IPoint point) {
        super(source, target, eventType);
        this.point = point;
    }

    public PacmanTouchPoint(Source source, Target target, IPoint point) {
        super(source, target);
        this.point = point;

    }

    public IPoint getPoint()
    {
        return point;
    }

}
