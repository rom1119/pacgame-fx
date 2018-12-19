package com.pacgame.provider.interfaces;

import com.pacgame.provider.Proxy;

public interface IParentableProviderProxy<T extends Proxy> {
    
    void setParent(T el);
    T getParent();
}
