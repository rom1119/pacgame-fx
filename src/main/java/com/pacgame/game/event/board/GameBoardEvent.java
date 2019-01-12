package com.pacgame.game.event.board;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class GameBoardEvent extends Event {

    public static final EventType<GameBoardEvent> GAME_BOARD_ANY_EVENT = new EventType<>(Event.ANY_EVENT, "GAME_BOARD_ANY_EVENT");


    public GameBoardEvent(Source source, Target target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public GameBoardEvent(Source source, Target target) {
        super(source, target);
    }
}
