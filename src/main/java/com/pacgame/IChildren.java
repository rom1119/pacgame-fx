package com.pacgame;

import java.util.Map;

public interface IChildren<T> {

    void addChildren(T el);
    void removeChildren(T el);

    boolean hasChildren(T el);

}
