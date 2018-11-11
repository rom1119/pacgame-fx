package com.pacgame.provider.event;

public interface ChangeListener<T> {

    void onChange(T oldVal, T newVal);
}
