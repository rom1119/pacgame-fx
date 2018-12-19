package com.pacgame.provider.interfaces;

import com.pacgame.provider.Proxy;

import java.util.Map;

public interface IChildrenProviderProxy<T extends Proxy> {

    void addChildren(T el);
    void removeChildren(T el);
    Map<String, T> getChildren();

    boolean hasChildren(T el);

}
