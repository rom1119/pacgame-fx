package com.pacgame.provider.event.listener;

public interface ChangeListener<T> {

    void onChange(T oldVal, T newVal);
}
