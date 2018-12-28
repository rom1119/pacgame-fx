package com.pacgame.game.event.ui;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class SelectMenuItem extends UIEvent {

    public static final EventType<UIEvent> SELECT_MENU_ITEM_EVENT = new EventType<>(UIEvent.UI_ANY_EVENT, "SELECT_MENU_ITEM_EVENT");


    public SelectMenuItem(Source source, Target target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public SelectMenuItem(Source source, Target target) {
        super(source, target);
    }
}
