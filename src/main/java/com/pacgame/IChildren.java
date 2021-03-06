package com.pacgame;

import java.util.Map;

public interface IChildren<T> {

    void addChildren(T el);
    void removeChildren(T el);
    Map<String, T> getChildren();


    boolean hasChildren(T el);

}
