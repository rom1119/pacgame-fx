package com.pacgame.game.event;

import com.pacgame.game.PlatformTools;

public class ExitGameImpl implements ExitGame {

    private Source source;
    private Target target;
    private PlatformTools platformTools;

    @Override
    public void setPlatformTools(PlatformTools platformTools) {
        this.platformTools = platformTools;
    }

    @Override
    public PlatformTools getPlatformTools() {
        return platformTools;
    }

    @Override
    public Source getSource() {
        return source;
    }

    @Override
    public Target getTarget() {
        return target;
    }

    @Override
    public void exit() {
        if (platformTools != null) {
            platformTools.closePlatform();
        }
    }
}
