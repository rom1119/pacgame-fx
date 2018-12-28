package com.pacgame.game.event;

import com.pacgame.game.PlatformTools;

public class AppEvent extends Event {

    public static final EventType<AppEvent> APP_ANY_EVENT = new EventType<>(Event.ANY_EVENT, "APP_ANY_EVENT");


    private PlatformTools platformTools;

    public AppEvent(Source source, Target target, EventType<? extends AppEvent> eventType) {
        super(source, target, eventType);
    }

    public AppEvent(Source source, Target target) {
        super(source, target);
    }

    public void setPlatformTools(PlatformTools platformTools) {
        this.platformTools = platformTools;
    }

    public PlatformTools getPlatformTools() {
        return platformTools;
    }
}
