package com.pacgame.game.adapter;

import com.pacgame.game.PlatformTools;
import com.pacgame.provider.appTools.AppTools;

public class PlatformToolsAdapter implements PlatformTools {

    private AppTools providedObject;

    public PlatformToolsAdapter(AppTools providedObject) {
        this.providedObject = providedObject;
    }

    @Override
    public void closePlatform() {
        providedObject.exit();
    }
}
