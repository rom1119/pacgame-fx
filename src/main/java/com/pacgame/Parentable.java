package com.pacgame;

import java.util.Collection;
import java.util.Map;

public interface Parentable<T> {
    
    void setParent(T el);
    T getParent();
}
