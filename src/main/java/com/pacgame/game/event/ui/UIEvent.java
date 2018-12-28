package com.pacgame.game.event.ui;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class UIEvent extends Event {

    public static final EventType<UIEvent> UI_ANY_EVENT = new EventType<>(Event.ANY_EVENT, "UI_ANY_EVENT");

    public UIEvent(Source source, Target target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public UIEvent(Source source, Target target) {
        super(source, target);
    }
}
