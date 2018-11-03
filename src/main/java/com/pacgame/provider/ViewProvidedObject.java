package com.pacgame.provider;

import com.pacgame.provider.proxy.ViewProxy;

public abstract class ViewProvidedObject extends ProvidedObject {

    protected ViewProxy proxy;

    @Override
    public ViewProxy getProxy() {
        return proxy;
    }
}
