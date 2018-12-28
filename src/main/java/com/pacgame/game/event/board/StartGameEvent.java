package com.pacgame.game.event.board;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class StartGameEvent extends GameBoardEvent {
    public StartGameEvent(Source source, Target target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public StartGameEvent(Source source, Target target) {
        super(source, target);
    }
}
