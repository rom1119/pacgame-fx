package com.pacgame.provider.interfaces;

public interface IParentableProvider<T> {
    
    void setParent(T el);
    T getParent();
}
