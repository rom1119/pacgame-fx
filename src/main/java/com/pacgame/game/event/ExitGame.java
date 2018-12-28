package com.pacgame.game.event;

import com.pacgame.game.PlatformTools;

public class ExitGame extends AppEvent {

    public static final EventType<ExitGame> APP_EXIT_EVENT = new EventType<>(AppEvent.APP_ANY_EVENT, "APP_EXIT_EVENT");

    public ExitGame(Source source, Target target, EventType<? extends AppEvent> eventType) {
        super(source, target, eventType);
    }

    public ExitGame(Source source, Target target) {
        super(source, target);
    }


    public void exit() {
        if (getPlatformTools() != null) {
            getPlatformTools().closePlatform();
        }
    }
}
