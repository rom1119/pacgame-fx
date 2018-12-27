package com.pacgame.provider.appTools;

import com.pacgame.provider.ProvidedObject;
import com.pacgame.provider.Proxy;

public class AppTools extends ProvidedObject {

    private AppToolsProxy proxy;

    public AppTools() {
        proxy = new AppToolsProxy();
    }

    @Override
    protected AppToolsProxy getProxy() {
        return proxy;
    }

    public void exit()
    {
        getProxy().exit();
    }
}
