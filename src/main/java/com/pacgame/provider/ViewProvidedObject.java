package com.pacgame.provider;

public abstract class ViewProvidedObject extends ProvidedObject {

    protected ViewProxy proxy;

    @Override
    public ViewProxy getProxy() {
        return proxy;
    }
}
