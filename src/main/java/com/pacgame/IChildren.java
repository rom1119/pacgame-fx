package com.pacgame;

import java.util.Map;

public interface IChildren<T> {

    Map<String, T> getChildren();

    void addChildren(T el);
    void removeChildren(T el);

    boolean hasChildren(T el);

}
