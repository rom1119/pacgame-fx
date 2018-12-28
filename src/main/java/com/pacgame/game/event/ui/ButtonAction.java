package com.pacgame.game.event.ui;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class ButtonAction extends UIEvent {

    public static final EventType<UIEvent> BACK_TO_MENU_EVENT = new EventType<>(UIEvent.UI_ANY_EVENT, "BACK_TO_MENU_EVENT");

    public ButtonAction(Source source, Target target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public ButtonAction(Source source, Target target) {
        super(source, target);
    }
}
