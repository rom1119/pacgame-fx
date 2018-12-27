package com.pacgame.game.event;

import com.pacgame.game.PlatformTools;

public interface AppEvent extends Event {

    void setPlatformTools(PlatformTools platformTools);

    PlatformTools getPlatformTools();

}
