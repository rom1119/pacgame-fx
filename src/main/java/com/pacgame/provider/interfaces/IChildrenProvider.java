package com.pacgame.provider.interfaces;

import com.pacgame.provider.ViewProxy;

import java.util.Map;

public interface IChildrenProvider<T> {

    void addChildren(T el);
    void removeChildren(T el);
    Map<String, T> getChildren();

    boolean hasChildren(T el);

}
