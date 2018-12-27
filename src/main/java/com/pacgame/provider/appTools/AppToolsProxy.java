package com.pacgame.provider.appTools;

import com.pacgame.provider.Proxy;
import javafx.application.Platform;

class AppToolsProxy extends Proxy {

    private Platform platform;

    public AppToolsProxy() {
    }

    @Override
    protected Object getProxyObject() {
        return null;
    }

    public void exit()
    {
        Platform.exit();
    }
}
